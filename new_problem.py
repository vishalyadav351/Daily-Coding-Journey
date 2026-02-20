import os
import sys

# Template for the Problem's README
README_TEMPLATE = """# {problem_name}

## 📝 Problem Statement
## 💡 Intuition & Approach
## 🛠️ Dry Run / Visualization
![Dry Run](./assets/dry-run.jpg)

## 💻 Complexity
- **Time Complexity:** O(?)
- **Space Complexity:** O(?)
"""

def create_problem_structure(category, problem_name):
    # Format folder name: "Two Sum" -> "Two-Sum"
    safe_name = problem_name.replace(" ", "-")
    
    # Path setup
    base_path = os.path.join(os.getcwd(), category, safe_name)
    assets_path = os.path.join(base_path, "assets")
    
    # Create directories
    os.makedirs(assets_path, exist_ok=True)
    
    # Create solution file
    with open(os.path.join(base_path, "solution.py"), "w") as f:
        f.write(f"# Solution for {problem_name}\n\ndef solve():\n    pass\n")
        
    # Create README file
    with open(os.path.join(base_path, "README.md"), "w") as f:
        f.write(README_TEMPLATE.format(problem_name=problem_name))
        
    print(f"✅ Successfully created structure for: {category}/{safe_name}")
    print(f"📂 Go to: {base_path}")

if __name__ == "__main__":
    if len(sys.argv) < 3:
        print("Usage: python new_problem.py <Category> <ProblemName>")
        print('Example: python new_problem.py "Arrays" "Two Sum"')
    else:
        create_problem_structure(sys.argv[1], sys.argv[2])
        