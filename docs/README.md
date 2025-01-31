# 👩🏻‍💻 구현 기능 목록
## ☑️ 게임 로직 정리


1. 프로그램 시작 안내 문구를 출력한다.
   (안내 문구 메시지 : `"다리 건너기 게임을 시작합니다."`<br>


2. 플레이어에게 다리의 길이를 입력받는다.<br>
   (입력 요청 메시지 : `"다리의 길이를 입력해주세요."`<br>
   -**다리 길이에 대한 유효성 검사를 실행한다.**<br>
   (유효성 검사를 실패할 경우 `IllegalArgumentException`을 발생시킨 후, 예외 메시지를 출력하고 재입력 받는다. 예외 메시지는 `"[ERROR]"`로 시작해야 한다.)<br>
   a. 플레이어의 입력값은 필수이다.<br>
   b. 다리의 길이는 최소 3 이상 최대 20 이하이다. <br>
   c. 입력값은 숫자만을 허용한다.<br>


3. 플레이어에게 이동할 칸을 입력받는다.<br>
   (입력 요청 메시지 : `"이동할 칸을 선택해주세요. (위: U, 아래: D)"`<br>
   -**입력값에 대한 유효성 검사를 실행한다.**<br>
   (유효성 검사를 실패할 경우 `IllegalArgumentException`을 발생시킨 후, 예외 메시지를 출력하고 재입력 받는다. 예외 메시지는 `"[ERROR]"`로 시작해야 한다.)<br>
   a. 플레이어의 입력값은 필수이다.<br>
   b. 입력값은 U(위 칸), D(아래 칸)만을 허용한다. <br>


4. **다리 건너기 로직 정리** <br>
   -**다리 생성 로직** <br>
   a. 위아래 둘 중 하나의 칸만 건널 수 있다.<br>
   b. 무작위 값을 뽑는다. (무작위 값이 0인 경우 아래 칸, 1인 경우 위 칸이 건널 수 있는 칸이 된다.)<br>
   -**다리 건너기 로직** <br>
   a. 플레이어가 위 칸(U), 아래칸(D) 중 하나를 입력한다.<br>
   b. 이동한 칸을 건널 수 있다면 O로 표시한다.<br>
   c. 건널 수 없다면 X로 표시한다.<br>
   -**성공 로직** <br>
   a. 다리를 모두 건너면 게임이 종료된다.<br>
   -**실패 로직** <br>
   a. 다리를 건너다 실패하면 게임을 재시작하거나 종료한다.<br>
   b. 게임을 재시작할 경우 처음의 다리 길이를 재사용한다.<br>


5. 플레이어에게 재시작/종료 여부를 입력받는다.<br>
   (입력 요청 메시지 : `"게임을 다시 시도할지 여부를 입력해주세요 (재시도: R, 종료: Q)"`<br>
   -**입력값에 대한 유효성 검사를 실행한다.**<br>
   (유효성 검사를 실패할 경우 `IllegalArgumentException`을 발생시킨 후, 예외 메시지를 출력하고 재입력 받는다. 예외 메시지는 `"[ERROR]"`로 시작해야 한다.)<br>
   a. 플레이어의 입력값은 필수이다.<br>
   b. 입력값은 R(재시도), Q(종료)만을 허용한다. <br>


6. 아래의 양식으로 최종 게임 결과를 출력한다.<br>
   `"최종 게임 결과"`<br>
   `"[ O |   |   ]"`<br>
   `"[   | O | O ]"`<br>


7. 아래의 양식으로 게임 성공 여부와 총 시도 횟수를 출력한다. <br>
   `"게임 성공 여부: 성공"`<br>
   `"총 시도한 횟수: 2"`<br>
   a. 게임 결과의 총 시도한 횟수는 첫 시도를 포함해 게임을 종료할 때까지 시도한 횟수를 나타낸다.<br>