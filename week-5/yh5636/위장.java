import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
		int answer = 1;
		ArrayList<String> clotheTypeList = new ArrayList<String>();
		HashMap<String, Integer> clotheCountMap = new HashMap<String, Integer>();	//key-의상 종류, val-의상 갯수
			
		for(String[] clothe: clothes){
			String ct = clothe[1];
			if(clotheCountMap.containsKey(ct)){
				clotheCountMap.put(ct, clotheCountMap.get(ct)+1);
			}else{
				clotheCountMap.put(ct, 2);	//종류별로 안입는 경우 추가해서 계산
				clotheTypeList.add(ct);	//옷종류 배열
			}
		}
		
		for(String ct : clotheTypeList){
			answer *= clotheCountMap.get(ct);
		}
		
        return answer-1;

    }
}