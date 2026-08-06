class Solution { // done done done... also do leetcode 57 similar...
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        //1. sort by begininh
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        //2. list to store
        List<int[]> merged = new ArrayList<>();

        //3. final logic through iteration
        for(int[] interval : intervals) {
            // case1: non overlapped
            if(merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else { // c2: overlapping -> merge it
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        //4. convert list to arr
        return merged.toArray(new int[merged.size()][]);

    }

    // // Driver Code
    // public static void main(String[] args) {

    //     int[][] intervals = {
    //             {1, 3},
    //             {2, 6},
    //             {8, 10},
    //             {15, 18}
    //     };

    //     int[][] result = merge(intervals);

    //     System.out.println("Merged Intervals:");

    //     for (int[] interval : result) {
    //         System.out.println(Arrays.toString(interval));
    //     }
    // }
}


// ====================== SORTING CHEAT SHEET ======================

// // 1. Sort 1D int[] Array (Ascending)
// Arrays.sort(arr);

// // ---------------------------------------------------------------

// // 2. Sort 1D Integer[] Array (Descending)
// Arrays.sort(arr, Collections.reverseOrder());

// // ---------------------------------------------------------------

// // 3. Sort String[] (Ascending)
// Arrays.sort(arr);

// // ---------------------------------------------------------------

// // 4. Sort String[] (Descending)
// Arrays.sort(arr, Collections.reverseOrder());

// // ---------------------------------------------------------------

// // 5. Sort 2D Array by First Column (Ascending)
// Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

// // ---------------------------------------------------------------

// // 6. Sort 2D Array by First Column (Descending)
// Arrays.sort(intervals, (a, b) -> Integer.compare(b[0], a[0]));

// // ---------------------------------------------------------------

// // 7. Sort 2D Array by Second Column (Ascending)
// Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

// // ---------------------------------------------------------------

// // 8. Sort 2D Array by Second Column (Descending)
// Arrays.sort(intervals, (a, b) -> Integer.compare(b[1], a[1]));

// // ---------------------------------------------------------------

// // 9. Sort 2D Array by First Column,
// //    If Equal -> Sort by Second Column
// Arrays.sort(intervals, (a, b) -> {
//     if (a[0] == b[0])
//         return Integer.compare(a[1], b[1]);
//     return Integer.compare(a[0], b[0]);
// });

// // ---------------------------------------------------------------

// // 10. Sort 2D Array by Second Column,
// //     If Equal -> Sort by First Column
// Arrays.sort(intervals, (a, b) -> {
//     if (a[1] == b[1])
//         return Integer.compare(a[0], b[0]);
//     return Integer.compare(a[1], b[1]);
// });

// // ---------------------------------------------------------------

// // 11. Sort List<Integer> (Ascending)
// Collections.sort(list);
// // OR
// list.sort(null);

// // ---------------------------------------------------------------

// // 12. Sort List<Integer> (Descending)
// Collections.sort(list, Collections.reverseOrder());
// // OR
// list.sort(Collections.reverseOrder());

// // ---------------------------------------------------------------

// // 13. Sort List<String> (Ascending)
// Collections.sort(list);

// // ---------------------------------------------------------------

// // 14. Sort List<String> (Descending)
// Collections.sort(list, Collections.reverseOrder());

// // ---------------------------------------------------------------

// // 15. Sort List<int[]> by First Column
// list.sort((a, b) -> Integer.compare(a[0], b[0]));

// // ---------------------------------------------------------------

// // 16. Sort List<int[]> by Second Column
// list.sort((a, b) -> Integer.compare(a[1], b[1]));

// // ---------------------------------------------------------------

// // 17. Sort Objects by Field (Ascending)
// students.sort(Comparator.comparingInt(s -> s.marks));

// // ---------------------------------------------------------------

// // 18. Sort Objects by Field (Descending)
// students.sort(Comparator.comparingInt((Student s) -> s.marks).reversed());

// // ---------------------------------------------------------------

// // 19. Partial Sorting (Only Index l to r-1)
// Arrays.sort(arr, l, r);

// // Example:
// // Arrays.sort(arr, 0, mid);

// // ---------------------------------------------------------------

// // 20. Comparator (Old Style)
// Arrays.sort(intervals, new Comparator<int[]>() {
//     @Override
//     public int compare(int[] a, int[] b) {
//         return Integer.compare(a[0], b[0]);
//     }
// });

// ---------------------------------------------------------------

// NOTE:
// Ascending  -> Integer.compare(a, b)
// Descending -> Integer.compare(b, a)
//
// Prefer Integer.compare() instead of:
// a - b
// because subtraction may overflow.

// ====================== END ======================