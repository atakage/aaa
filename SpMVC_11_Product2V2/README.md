# 상품 정보 관리 프로젝트


## ajax를 활용하여 상품정보 보기 실행
## 파일 업로드 기능 추가
* 파일 업로드에서는 파일의 내용(파일 자체)을 직접 DB에 저장하기도 하지만, 그렇게 할 경우 DBMS에 많은 무리가 생겨 성ㄷ능상 문제가 됨
* 파일은 public(resource)으로 공개된 폴더에 저장을 하고 DB에는 파일의 경로, 이름만 저장하여 보여줄 때 그 경로를 img tag를 사용해 보여줌



### 파일 업로드 form
* 파일 업로드를 위해서 input type="file" tag를 사용하고
* 파일을 선택할 수 있도록 수행함 

#### 중요!!
*파일 업로드 폼에는 반드시 enctype 속성을 지정함
*enctype="multipart/form-data"


### 파일 size
*commonsMultipartResolver 클래스에 파일 최대 업로드 크기를 지정해 주어야 함
*단위는 byte 단위로 설정
*1KB = 1024, 1MB = 1024KB, 



### 파일을 저장할 폴더
*servlet-context.xml의 resources로 폴더를 설정하고 외부에 개방을 해줘야 함
*가상디렉토리: resources tag를 사용하여 mapping으로 설정한 값
*실제폴더: location으로 설정한 값
*web에서 server/context/mapping으로 접근을 시도하면 실제로는 location폴더의 내용에 접근할 수 있도록 설정하는 것

*로컬 프로젝트에 있는 파일들을 프로젝트 서버로 배포(deploy)하면 파일들이 모두 자동으로 복사되어 문제를 일으키지 않음
*만약 서버가 실행된 상태에서 파일업로드를 통해서 서버에 복사한 파일은 실제 로컬에 없는 파일이기 때문에 만약 서버를 clean 하거나 프로젝트를 다시 deploy하면 모든 내용이 삭제돼 버림
*이러한 현상을 방지하기 위해서 files 폴더를 tomcat 서버와 별개의 장소에 만들어 두고 이 폴더를 외부에 개방을 함

*<resources mapping="files/**" location="file:///c:/bizwork/files/"

*resources mapping을 위와 같이 설정하면 서버를 통해 /files/ 디렉토리에 접근을 하면 실제로는 c:/bizwork/files 폴더에 접근을 허락하는 것
*이 설정을 수행했으나 만약 c:/bizwork/files 폴더에 접근이 되지 않을 경우 BeanNameUrlHandlerMapping을 servlet-context.xml에 beans:bean으로 등록을 해줌
*beanNameUrlHandleMapping: Dispatcher가 기본으로 사용하는 Mapping인데 간혹 일부 기능에서참조를 못하는 경우가 있어서 bean으로 설정