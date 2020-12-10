Step-2   

3 X 3의 2차원 배열이 아래처럼 있다.   
R R W   
G C W   
G B B    

사용자 입력을 받아서 아래의 동작을 하는 프로그램을 구현하시오   
  * U  가장 윗줄을 왼쪽으로 한 칸 밀기 RRW -> RWR   
  * U' 가장 윗줄을 오른쪽으로 한 칸 밀기 RRW -> WRR   
  * R  가장 오른쪽 줄을 위로 한 칸 밀기 WWB -> WBW
  * R' 가장 오른쪽 줄을 아래로 한 칸 밀기 WWB -> BWW
  * L  가장 왼쪽 줄을 아래로 한 칸 밀기 RGG -> GRG (L의 경우 R과 방향이 반대임을 주의한다.)
  * L' 가장 왼쪽 줄을 위로 한 칸 밀기 RGG -> GGR
  * B  가장 아랫줄을 오른쪽으로 한 칸 밀기 GBB -> BGB (B의 경우도 U와 방향이 반대임을 주의한다.)
  * B' 가장 아랫줄을 왼쪽으로 한 칸 밀기 GBB -> BBG
  * Q  Bye~를 출력하고 프로그램을 종료한다.   
  
동작 예시   
  R R W   
  G C W   
  G B B   
  
  CUBE> UUR   
  
  U   
  R W R    
  G C W  
  G B B   
  
  U    
  W R R     
  G C W    
  G B B   
  
  R   
  W R W   
  G C B   
  G B R   
  
  CUBE> Q   
  Bye~   