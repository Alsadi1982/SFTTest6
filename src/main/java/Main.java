import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String result = "";
        List<String> newStrArr = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("06.txt"))){

            String str;
            while ((str = reader.readLine()) != null){
                for (int i = 0; i < str.length(); i++){
                    if (newStrArr.size() < str.length()){
                        newStrArr.add("" + str.charAt(i));
                    }else {
                        newStrArr.set(i, newStrArr.get(i) + str.charAt(i));
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String elem: newStrArr){
            Map<Character, Integer> map = new HashMap<>();
            char[] charArr = elem.toCharArray();
            for (char c : charArr) {
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                } else {
                    map.put(c, map.get(c) + 1);
                }
            }
            
            char frequentChar = 0;
            int max = 0;
            for (Map.Entry<Character, Integer> item: map.entrySet()){
                if (item.getValue() > max){
                    max = item.getValue();
                    frequentChar = item.getKey();
                }
            }

            result += frequentChar;
        }

        System.out.println(result);


    }
}
