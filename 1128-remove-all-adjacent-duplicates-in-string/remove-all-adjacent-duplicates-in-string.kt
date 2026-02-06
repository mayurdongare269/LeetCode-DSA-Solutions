class Solution {
    fun removeDuplicates(s: String): String {
        val arr = s.toCharArray()
        var k = -1

        for (i in arr.indices) {
            if (k >= 0 && arr[k] == arr[i]) {
                k--
            } else {
                k++
                arr[k] = arr[i]
            }
        }
        return String(arr, 0, k + 1)
    }
}
