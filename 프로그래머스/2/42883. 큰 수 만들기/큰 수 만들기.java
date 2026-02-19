class Solution {

    public String solution(String number, int k) {

        if (number == null || number.length() == 0)
            return "";

        StringBuilder sb = new StringBuilder();

        for (char n : number.toCharArray()) {

            while (sb.length() > 0 && k > 0 &&
                   sb.charAt(sb.length() - 1) < n) {

                sb.deleteCharAt(sb.length() - 1);
                k--;
            }

            sb.append(n);
        }

        if (k > 0 && sb.length() >= k) {
            sb.setLength(sb.length() - k);
        }

        return sb.toString();
    }
}
