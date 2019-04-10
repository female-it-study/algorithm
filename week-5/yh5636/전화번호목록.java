class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        for (String pn : phone_book) {
            for (int i = 0; i < phone_book.length; i++) {
                if(pn.equals(phone_book[i])){continue;}
                if(pn.startsWith(phone_book[i])){answer = false; break;}
            }
		}

        return answer;
    }
}