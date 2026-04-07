class Robot {
    private int width, height, perimeter;
    private int pos = 0;
    private boolean hasMoved = false;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        // Perimeter calculation: edges minus duplicate corners
        this.perimeter = 2 * (width + height - 2);
    }

    public void step(int num) {
        hasMoved = true;
        pos = (pos + num) % perimeter;
    }

    public int[] getPos() {
        // Linear position ko (x, y) coordinates mein convert karna
        if (pos < width) {
            return new int[]{pos, 0};
        } else if (pos < width + height - 1) {
            return new int[]{width - 1, pos - (width - 1)};
        } else if (pos < 2 * width + height - 2) {
            return new int[]{(width - 1) - (pos - (width + height - 2)), height - 1};
        } else {
            return new int[]{0, (height - 1) - (pos - (2 * width + height - 3))};
        }
    }

    public String getDir() {
        // Initial state check: Agar abhi tak ek bhi step nahi chala, toh hamesha East
        if (!hasMoved || pos == 0) {
            // Agar move hone ke baad 0 par aaya hai, toh matlab pura chakkar kaat liya -> South
            // Agar move hi nahi hua, toh initial state -> East
            return hasMoved ? "South" : "East";
        }

        // Standard boundary direction checks
        if (pos < width) return "East";
        if (pos < width + height - 1) return "North";
        if (pos < 2 * width + height - 2) return "West";
        return "South";
    }
}