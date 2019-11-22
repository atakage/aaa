<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	// JSP 파일 내에 Java 코드를 작성하는 영역

	int num1 = 30;
	int num2 = 40;
	int sum = num1 + num2;

	System.out.println(sum);
%>
<!DOCTYPE html>
<html>
<!-- head tag는 페이지에 대한 정보 등을 기록하는 부분 
	웹 페이지에 표시되지는 않지만 웹 페이지에 어떤 것을 표시하기 위한 다양한 설정 등을 기록하는 부분

-->
<head>
<meta charset="UTF-8">
<!--  웹 페이지를 표시할 때 제목으로 사용되는 문자열 -->
<title>나의 첫 번째 홈페이지</title>
</head>
<!--  웹 페이지에 나타날 정보들을 표시하는 영역 -->
<!--  디자인과 관련된 ㅁㄴ서표시를 하는 부분 -->
<body>
<!--  h tag는 h1 ~ h6까지 사용되며 본문보다 큰 글자를 표시 -->

	<h2>나는 Home.jsp입니다</h2>
	<h3>반갑습니다</h3>
	<h4>우리나라만세</h4>
	<h4><%=sum %></h4>
	<p>문단tag</p>
	<p>본문tag</p>
	<p>웹페이지에서는 Enter의 의미가 없다</p>
	<p>한 개의 문단 내의 문자열이 매우 커서 한 줄에 표시되지 않을 때는 자동으로 다음 줄로 넘겨져서 표시가 됨(Auto Word Wrap)</p>
	<p>문서를 작성하면서 Enter 키를 입력해도 웹페이지에서는 단지 1개의 빈칸으로 인식
	여러 줄에 걸쳐 문서를 작성하기 위해 Enter를 입력하지만 실제 웹페이지에서 볼 때는 단지 1개의 빈칸으로만 인식</p>
	<p>문자열을 표시하면서 br tag를 사용하면 해당 위치에서 강제 줄바꿈이 됨 br tag는 임의로 문단내에서 문자열을 여러줄에 표시하고자 할 때 사용 </p>
	
	<p>br tag로 줄바꿈을 하면 문단내에서는<br/> 
	위아래 여백이 없는 상태로 문자열들이 <br/>
	표시됨
	
	<p>우리나라<br/>
	대한민국<br/>
	Republic of Korea</p>
	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa. Commodo odio aenean sed adipiscing diam donec adipiscing tristique. Mi eget mauris pharetra et. Non tellus orci ac auctor augue. Elit at imperdiet dui accumsan sit. Ornare arcu dui vivamus arcu felis. Egestas integer eget aliquet nibh praesent. In hac habitasse platea dictumst quisque sagittis purus. Pulvinar elementum integer enim neque volutpat ac.
Senectus et netus et malesuada. Nunc pulvinar sapien et ligula ullamcorper malesuada proin. Neque convallis a cras semper auctor. Libero id faucibus nisl tincidunt eget. Leo a diam sollicitudin tempor id. A lacus vestibulum sed arcu non odio euismod lacinia. In tellus integer feugiat scelerisque. Feugiat in fermentum posuere urna nec tincidunt praesent. Porttitor rhoncus dolor purus non enim praesent elementum facilisis. Nisi scelerisque eu ultrices vitae auctor eu augue ut lectus. Ipsum faucibus vitae aliquet nec ullamcorper sit amet risus. Et malesuada fames ac turpis egestas sed. Sit amet nisl suscipit adipiscing bibendum est ultricies. Arcu ac tortor dignissim convallis aenean et tortor at. Pretium viverra suspendisse potenti nullam ac tortor vitae purus. Eros donec ac odio tempor orci dapibus ultrices. Elementum nibh tellus molestie nunc. Et magnis dis parturient montes nascetur. Est placerat in egestas erat imperdiet. Consequat interdum varius sit amet mattis vulputate enim.
Sit amet nulla facilisi morbi tempus. Nulla facilisi cras fermentum odio eu. Etiam erat velit scelerisque in dictum non consectetur a erat. Enim nulla aliquet porttitor lacus luctus accumsan tortor posuere. Ut sem nulla pharetra diam. Fames ac turpis egestas maecenas. Bibendum neque egestas congue quisque egestas diam. Laoreet id donec ultrices tincidunt arcu non sodales neque. Eget felis eget nunc lobortis mattis aliquam faucibus purus. Faucibus interdum posuere lorem ipsum dolor sit.
	<p>위하여서 실로 따뜻한 같이, 위하여 없으면, 풀밭에 이것이다. 소리다.이것은 이는 어디 뿐이다. 청춘을 두기 열락의 가지에 과실이 우리의 쓸쓸하랴? 불어 하였으며, 인생의 되는 인생에 것이다. 방황하였으며, 곳으로 실현에 얼음과 그것은 것은 청춘의 두손을 청춘의 듣는다. 찾아다녀도, 노년에게서 얼마나 때문이다. 피는 힘차게 청춘이 곧 귀는 가슴이 밥을 자신과 있는가? 열매를 되는 너의 피어나는 있으며, 위하여 품고 운다. 트고, 심장은 못하다 맺어, 돋고, 노래하며 없는 굳세게 청춘이 말이다. 이것을 봄바람을 그들의 꽃이 간에 얼음과 위하여 따뜻한 대중을 교향악이다. 타오르고 가치를 위하여 인생을 쓸쓸하랴?

따뜻한 따뜻한 얼마나 방황하여도, 부패뿐이다. 이 사랑의 황금시대를 우리 운다. 위하여서 이성은 열매를 속잎나고, 약동하다. 간에 뜨고, 광야에서 사막이다. 두기 곧 용감하고 얼마나 우리 목숨이 우리의 보라. 더운지라 이는 이상 같이 것이다. 끓는 내는 그것을 보이는 길을 불러 있는 반짝이는 사는가 봄바람이다. 열매를 피어나기 붙잡아 충분히 있으며, 이것을 끓는다. 있는 희망의 싹이 힘차게 가는 풍부하게 새가 인생을 보라. 되는 풀이 때에, 피부가 인생의 아니다. 피어나는 가진 우리의 이것을 이것이다.

눈에 만천하의 찬미를 너의 약동하다. 역사를 우리의 오직 우리 황금시대다. 사랑의 밥을 피는 청춘을 돋고, 우리는 지혜는 인간이 부패뿐이다. 청춘의 이 있음으로써 장식하는 오직 있으며, 그와 바로 인생에 봄바람이다. 살 있음으로써 이상은 철환하였는가? 이상의 얼음에 속잎나고, 모래뿐일 할지니, 사막이다. 구하기 황금시대의 쓸쓸한 얼마나 밝은 바이며, 끓는다. 봄날의 그러므로 때까지 끓는 청춘 하는 있으랴? 사는가 생명을 공자는 든 곳이 사랑의 피가 가슴이 소담스러운 있으랴? 얼마나 얼마나 청춘의 영원히 충분히 커다란 황금시대다. 굳세게 방지하는 황금시대의 이것은 끝까지 것은 너의 것이다.</p>
</body>
</html>