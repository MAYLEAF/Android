# Android
#### Splash 
스플래시 스크린를 구현한 인트로 엑티비티입니다.
apk 실행시 3초동안 나타난 후 메인으로 가게 하는 역할입니다.
---------------------------------------------
이 칸에 있는 클래스는 모두 엑티비티를 구현하기 위해 각각의 콘텐트 뷰를 가지고 있습니다.
그리고 기본 엑티비티의 틀은 네비게이션 드로어입니다. 그리고 백 에로우는 우측 상단의 점 세개가 있는 버튼을 누르면 백프레스를 할수 있는 모달이 팝됩니다.

#### main
메인 엑티비티를 구현한 클래스입니다.
기타의 이해, 기타 관리법, 기타 연주 방법, 젬베의 종류, 일정관리, 관련정보.
위 6개의 카테고리를 아이콘을 클릭해 접근할 수 있도록 했습니다. 
그리고 일정관리와 관련정보는 하위 카테고리를 가지고 있지 않아 네비게이션 드로어에 추가되어있지 않습니다.
아이콘에는 온클릭이 구현되어있습니다.
온클릭을 누르면 각각 인텐트를 통해서 해당 엑티비티로 넘어 
#### Division
상위카테고리를 클릭했을때 접근할 수 있는 액티비티를 구현한 클래스입니다.
네비바의 기능 메인과 같고, 메인 엑티비티에서 넘어온 메세지를 통해서 어떤 버튼을 보여줄지
선택할 수 있도고 구현되어있습니다.
#### Content
디비전 엑티비티의 버튼 혹은 네비게이션 드로어의 익스펜더블 리스트를 통해 접근할 수 있는 엑티비티를 구현한 클래스로, 하위 리스트의 콘텐츠를 볼 수 있도록합니다.
상위 엑티비티에서 전달한 인텐트에 담겨있는 스트링 메세지를 통해 
텍스트의 스트링을 따로따로 불러옵니다.


#### ShopList
통기타를 살 수 있는 리페어샵과 기타카페를 정렬된 리스트로 구현한 클래스입니다.
기타카페는 제가 아는 곳이 하나밖에 없어서 하나만 있습니다.
메뉴 모델 클래스의 CompareTo 메소드를 통해 메뉴 이름순으로 리스트를 정렬했습니다.


-----------------------------------------------
#### ExpandableListAdapter
익스펜더블 리스트
카테고리리스트를 키값으로, 하위 리스트를 매핑하는 해쉬 맵과 키와 벨류를 get할 수 있는 메소드를 구현한 클래스입니다. 
#### MenuModel
리스트의 정보를 구현한 클래스입니다.
생성자에서 리스트의 이름과 그룹인지, 그리고 하위리스트를 가지고 있는지 보여줍니다.
그리고 CompareTo 메소드가 구현되어있습니다.


------------------------------------------------
calendar,
AddNote,
NotePreview

위 세 클래스는
applandeo라는 블로그에서 가져온 materialcalendarview api입니다.
