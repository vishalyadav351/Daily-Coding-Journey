# 🌟 1622. Fancy Sequence - O(1) Bulk Operations Solution

## 📌 Introduction

This repository contains a highly optimized Java solution for the *1622. Fancy Sequence* problem on LeetCode. The problem is classified as *Hard*, testing concepts in algorithmic efficiency and modular arithmetic.

### ❓ The Challenge

The objective is to implement a dynamic sequence (list) that supports two types of operations:
1.  *Element-wise Operations:* Standard append(val) and getIndex(idx).
2.  *Bulk Operations:* Update the entire existing sequence with addAll(inc) or multAll(m).

The core difficulty lies in the bulk operations. A brute-force approach that iterates over all elements for addAll or multAll will lead to *Time Limit Exceeded (TLE)* on large inputs, as the constraints imply a need for a much more efficient solution than $O(N)$ per bulk update.

## 💡 Key Design Principles & Intuition

To solve this, we must use a *Lazy Propagation* style approach. Instead of updating every single number in the list for bulk operations, we can:
1.  *Track Global State:* Maintain two global variables to store the cumulative transformation:
    * multiplier: Current total multiplication factor for the whole sequence.
    * adder: Current total addition value for the whole sequence.
2.  *Store Normalized Values:* This is the critical trick. When a new value v is appended, it shouldn't be affected by previous global operations. To achieve this, we store a "normalized" version of v such that the current global state, when applied to it, reverses the normalization and results in v.
3.  *Algebraic Transformation:* The final value of any stored number $x$ can be represented by the linear function:
    $$\text{Actual Value} = (x \times \text{multiplier}) + \text{adder}$$

## 🛠️ Algorithm & Implementation Details



The operations are implemented with the following time and space complexity:

| Operation | Logical Action | Mathematical State Update (Modulo) | Time Complexity | Space Complexity |
| :--- | :--- | :--- | :--- | :--- |
| *Fancy()* | Initialize state | multiplier = 1, adder = 0 | $O(1)$ | $O(1)$ |
| *append(val)* | *Normalize & Store:* $x = (\text{val} - \text{adder}) \times \text{multiplier}^{-1}$ | Add $x$ to nums | *$O(\log(MOD))$* | $O(1)$ |
| *addAll(inc)* | Update additive state | adder = (adder + inc) % MOD | *$O(1)$* | $O(1)$ |
| *multAll(m)* | Update multiplicative state | multiplier = (multiplier \times m) % MOD<br>adder = (adder \times m) % MOD | *$O(1)$* | $O(1)$ |
| *getIndex(idx)* | *De-normalize & Return:* $(\text{nums}[idx] \times \text{multiplier}) + \text{adder}$ | N/A | *$O(1)$* | $O(1)$ |

### 🚨 Crucial Concept: Modular Multiplicative Inverse

In modular arithmetic, direct division is not possible. To perform the division (val - adder) / multiplier during normalization, we must multiply by the *Modular Multiplicative Inverse* of multiplier. 

We use *Fermat's Little Theorem*, which states that if $p$ is a prime number (like our $10^9 + 7$), then:
$$a^{p-2} \equiv a^{-1} \pmod{p}$$

We calculate $a^{p-2}$ efficiently using a standard binary exponentiation function (power or pow), ensuring this inverse is computed in $O(\log(MOD))$ time.

## 💻 Java Code Solution

```java
import java.util.*;

/**
 * Highly optimized O(1) solution for bulk updates in Fancy Sequence.
 * Uses algebraic normalization and modular inverse (Fermat's Little Theorem) 
 * to handle large test cases without Time Limit Exceeded errors.
 */
class Fancy {
    private final List<Long> seq; // Stored normalized values
    private long mVal, aVal; // Global state trackers
    private static final int MOD = 1_000_000_007;

    public Fancy() {
        this.seq = new ArrayList<>();
        this.mVal = 1;
        this.aVal = 0;
    }

    /**
     * Appends a value, normalizing it to be independent of cur…
