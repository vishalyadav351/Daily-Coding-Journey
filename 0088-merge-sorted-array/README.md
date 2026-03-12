 Merge Sorted Array - LeetCode #88

## 📝 Problem Overview
The objective is to merge two sorted integer arrays, nums1 and nums2, into a single sorted array. The operation must be performed *in-place* within nums1.

- nums1 size: m + n
- nums2 size: n
- Initial valid elements in nums1: m

---

## 🚀 Technical Strategy: Backward Two-Pointer
Instead of merging from the beginning (which would require extra $O(n)$ space or $O(n^2)$ shifting), I implemented a *Backward Two-Pointer* approach. 

### Why this works:
By comparing elements from the end (the largest values) and placing them into the available buffer space at the tail of nums1, we eliminate the need for an auxiliary array. This ensures the most efficient memory management.

---

📊 Complexity Analysis
Time Complexity: O(m + n) - Single pass through both arrays.
Space Complexity: O(1) - Constant space, performing the merge in-place.
🧪 Dry Run
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Compare 3 and 6 \rightarrow Place 6 at nums1[5]
Compare 3 and 5 \rightarrow Place 5 at nums1[4]
Compare 3 and 2 \rightarrow Place 3 at nums1[3]
Compare 2 and 2 \rightarrow Place 2 at nums1[2]
Final Output: [1, 2, 2, 3, 5, 6]
## 💻 Implementation (Java)

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; 
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }
}
