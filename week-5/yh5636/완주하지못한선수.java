import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        String answer = "";	//미완 선수이름
        HashMap<String, Integer> ppMap = new HashMap<String, Integer>();	//완주자 맵
		
	    for(String pp : participant){
            if(ppMap.containsKey(pp)==true){
			    ppMap.put(pp, ppMap.get(pp)+1);	
			}else{
				ppMap.put(pp,1);
			}
		}
		
		for(String cp : completion){
			ppMap.put(cp, ppMap.get(cp) -1);	//key, value : 완주자 이름, 1
		}
		
		for (String key : ppMap.keySet()) {
            if (ppMap.get(key) != 0){
                answer = key;
            }
        }
        
        return answer;
    }
}