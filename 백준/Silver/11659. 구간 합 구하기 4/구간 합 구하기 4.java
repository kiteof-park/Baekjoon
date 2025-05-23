import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 데이터 개수, 질의 개수를 입력 받음
            // 질의 개수는 구간 합 계산 반복 횟수로 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st1.nextToken());
        int query = Integer.parseInt(st1.nextToken());
        
        // 2. N개의 수 입력 후 arr배열에 저장, 합 배열 sumArr에 저장
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int arr[] = new int[cnt];
        int sumArr[] = new int[cnt];
        for(int i = 0; i < cnt; i++){
            arr[i] =Integer.parseInt(st2.nextToken());
            sumArr[i] = (i == 0) ? arr[i] : sumArr[i - 1] + arr[i];
        }
                
        // 출력 버퍼 생성
        PrintWriter pw = new PrintWriter(System.out);
        
        // 3. 합을 구해야 하는 횟수(query)만큼 구간 합 계산
        // "1 3" -> 1, 3 
        for(int j = 0; j < query; j++){
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st3.nextToken());
            int end = Integer.parseInt(st3.nextToken());
            int result = (start == 1) ? sumArr[end - 1] : sumArr[end - 1] - sumArr[start - 2];
            pw.println(result);
        }
        pw.flush();        
    }
}