import java.util.*;

class Solution {

    static class Word {
        String text;
        int start;
        int end;
        boolean isSpoiler;
        int lastRange = -1;

        Word(String text, int start, int end) {
            this.text = text;
            this.start = start;
            this.end = end;
        }
    }

    public int solution(String message, int[][] spoiler_ranges) {
        List<Word> words = parseWords(message);

        // 각 스포 구간이 어떤 단어들과 겹치는지 확인
        int wordIdx = 0;
        for (int i = 0; i < spoiler_ranges.length; i++) {
            int rangeStart = spoiler_ranges[i][0];
            int rangeEnd = spoiler_ranges[i][1];

            // 현재 구간보다 완전히 왼쪽에 있는 단어들은 넘김
            while (wordIdx < words.size() && words.get(wordIdx).end < rangeStart) {
                wordIdx++;
            }

            int j = wordIdx;
            while (j < words.size() && words.get(j).start <= rangeEnd) {
                Word w = words.get(j);

                // 단어 [w.start, w.end] 와 구간 [rangeStart, rangeEnd] 가 겹치면
                if (w.end >= rangeStart) {
                    w.isSpoiler = true;
                    w.lastRange = i;   // 마지막으로 겹친 구간 번호 갱신
                }
                j++;
            }
        }

        // 일반 구간(스포일러에 한 번도 안 걸린 단어)에 등장한 단어들
        Set<String> normalWords = new HashSet<>();
        for (Word w : words) {
            if (!w.isSpoiler) {
                normalWords.add(w.text);
            }
        }

        // 마지막 공개 구간별로 단어를 모음
        List<List<Word>> revealedAt = new ArrayList<>();
        for (int i = 0; i < spoiler_ranges.length; i++) {
            revealedAt.add(new ArrayList<>());
        }

        // words는 이미 왼쪽 -> 오른쪽 순서이므로,
        // 이 순서대로 bucket에 넣으면 같은 클릭 내에서도 왼쪽 순서가 유지됨
        for (Word w : words) {
            if (w.isSpoiler) {
                revealedAt.get(w.lastRange).add(w);
            }
        }

        int answer = 0;
        Set<String> seenSpoilerWords = new HashSet<>();

        // 클릭 순서대로 처리
        for (int i = 0; i < spoiler_ranges.length; i++) {
            for (Word w : revealedAt.get(i)) {
                if (!normalWords.contains(w.text) && !seenSpoilerWords.contains(w.text)) {
                    answer++;
                }
                // "이전에 공개된 스포 방지 단어와 중복되지 않아야" 하므로
                // 중요 단어 여부와 상관없이 공개된 스포 단어는 기록
                seenSpoilerWords.add(w.text);
            }
        }

        return answer;
    }

    private List<Word> parseWords(String message) {
        List<Word> words = new ArrayList<>();
        int n = message.length();
        int i = 0;

        while (i < n) {
            if (message.charAt(i) == ' ') {
                i++;
                continue;
            }

            int start = i;
            while (i < n && message.charAt(i) != ' ') {
                i++;
            }
            int end = i - 1;

            words.add(new Word(message.substring(start, i), start, end));
        }

        return words;
    }
}