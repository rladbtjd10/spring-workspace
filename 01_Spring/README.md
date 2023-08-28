# 스프링 프레임워크(Spring Framework)

- 자바 애플리케이션 개발을 위한 오픈 소스 프레임워크로 줄여서 스프링(Spring) 이라고 한다.
- 동적인 웹 애플리케이션을 개발하기 위한 여러가지 서비스를 제공하고 있으며 대한민국 공공기관의 웹 서비스 개발시 사용을 권장하고 있는 전자정부 표준 프레임워크의 기반 기술로서 쓰이고 있다.

## 스프링의 특징

1. DI(Dependency Injection, 의존성 주입) -면접에서 중요 : 설정 파일이나 어노테이션을 통해 객체 간의 의존 관계를  설정하여 개발자가 직접 객체 간의 의존 관계를 생성할 필요가 없다.
2. AOP(Aspect Oriented Programming, 관점 지향 프로그래밍) : 트랜잭션, 로깅, 보안 등 공통으로 필요로 하는 기능의 경우 해당 기능들을 분리하여 관리한다.
3. POJO(Plain Old Java Object) : 일반적인 J2EE 프레임워크에 비해 특정 라이브러리를 사용할 필요가 없어 개발이 쉬우며, 기존 라이브러리의 지원이 용이하다.

## 스프링의 동작 구조

- 스프링 기반의 애플리케이션에서는 스프링 컨테이너 안에서 애플리케이션에서 필요한 객체가 생성되고 소멸된다.
- 즉, 스프링 컨테이너는 애플리케이션에서 필요한 객체를 생성하고, 객체들을 서로 연결하고, 소멸하는 등 객체의 생명주기를 관리한다.
- 스프링 컨테이너가 어떤 객체를 생성하고, 객체들을 어떻게 연결할지는 개발자가 설정해야 하는데 설정 방식은 크게 XML, 자바, 어노테이션을 통한 오토 와이어링 방식이다.

## 스프링의 구성 모듈

<img src="https://user-images.githubusercontent.com/26870393/182374318-408f2120-1126-496c-a053-e566de8af88b.png">

### 코어 컨테이너 계층

- 애플리케이션에서 필요한 객체들의 생성, 설정등의 처리 방법을 관리하는 컨테이너다.
- 모든 스프링 관련 모듈을 이 코어 컨테이너 기반으로 구축된다.

### AOP 계층

- 스프링은 AOP 계층을 통해 애스팩트 지향 프로그래밍(AOP)을 풍부하게 지원한다.
- AOP는 주로 애플리케이션 전체에 걸친 관심사와 각 객체 간의 결합도를 낮추는데 용이하다.

### 데이터 액세스 / 통합 계층 

-JDBC나 데이터베이스에 연결하는 계층으로, 트랜잭션에 해당하는 기능을 담당하여 영속성 프레임워크(MyBatis)와 연결을 담당한다.
- 이 모듈들을 이용하면 데이터 베이스 관련 코드를 깔끔하고 간단하게 만들 수 있고 데이터 베이스 리소스를 닫지 않아서 발생할 수 잇는 문제를 예방할 수 있다.

### Web 계층

- 스프링의 특징을 활용하여 객체간의 결합도를 낮추는 MVC 관련 모듈들을 제공해 준다.

### 테스트 계층

- 스프링에서 애플리케이션 테스트를 위한 모듈을 제공한다.
- 스프링 애플리케이션 컨텍스트에서 빈(Bean)을 로드하고 이 컨텍스트에 있는 빈을 이용하여 테스트 코드를 작성할 수 있다.


# DI(Dependency Injection)

## IoC(Inversion of Control)

- 프로그램을 구동하는데 필요한 객체에 대한 생성, 변경 등의 관리를 개발자가 아닌 컨테이너에서 직접 관리하는 것을 말한다.
- 스프링은 IoC 구조를 통해 구동 시 필요한 객체의 생성부터 소멸까지 해당 객체에 대한 관리를 직접 수행한다.
<img src="https://user-images.githubusercontent.com/26870393/182604427-d5e9f400-cc8c-410e-b583-df5de4e50bbc.png">

### 스프링 IoC 컨테이너
- 스프링에서 관리하는 객체를 `빈(Bean)`이라고 하고, 해당 빈들을 관리한다는 의미로 컨테이너를 `빈 팩토리(Bean Factory)`라고 한다.

### IoC 컽네이너의 역할
- 객체(Bean)의 생명주기와 의존성을 관리한다.
- 객체(Bean)의 생성, 초기화, 소멸 등의 처리를 담당한다.

<img src="https://user-images.githubusercontent.com/26870393/182604584-41a1d804-b021-4443-b8e1-6e72885460e7.png">

## DI

- DI(Dependency Injection)란 하나의 객체가 사용하는(의존하는) 다른 객체를 외부에서 생성하고 주입받아 사용하는 것을 말한다.
- 객체를 주입하는 방법으로는 메소드를 통한 의존성 주입 방법과 생성자를 통한 의존성 주입 방법이 있다.

### DI 설정 방법 - XML 방식

- 스프링 컨테이너 구동 시 생성해야 하는 객체(Bean)들과 의존 관계를 XML 파일로 작성하는 방식이다.
- `<beans>` 요소는 최상위 요소로 하위 요소들로 다양한 스프링 설정할 수 있다.
- `<bean>` 요소는 스프링 컨테이너가 관리할 빈을 선언하는 요소이다.

```xml
<beans>
    <beans id="student" class="com.kh.model.vo.Student">
</beans>
```

- Setter 메소드를 통해 의존 관계과 있는 빈을 주입하려면 `<property>` 요소를 사용한다. (단, 일치하는 setter 메소드가 있어야 한다.)

```xml
<beans>
    <bean id="student" class="com.kh.model.vo.Student">
        <property name="name" value="김아무" />
        <property name="age" value="20" /> 
        <property name="wallet" ref="money">
    </bean>

    <bean id="money" class="com.kh.model.vo.Wallet" />
</beans>
```

- 생성자를 통해 의존 관계과 있는 빈을 주입하려면 `<constructor-arg>` 요소를 사용한다. (단, 일치하는 매개변수가 있는 생성자가 있어야 된다.)

```xml
<beans>
    <bean id="student" class="com.kh.model.vo.Student">
        <constuctor-arg name="name" value="김아무" />
        <constuctor-arg name="Wallet" ref="money" />
    </bean>

    <bean id="money" class="com.kh.model.vo.Wallet" />
</beans>
```

# AOP(Aspect Oriented Programming)

- 관점 지향 프로그래밍(Aspect Oriented Programming)의 약자
- 애플리케이션의 여러 부분에 걸쳐 있는 기능을 횡단 관심사(Cross-cutting concerns)라고 한다.
- AOP는 횡단 관심사를 분리하고 분리한 기능을 어디에 어떻게 적용할지 선언적으로 정의할 수 있다.
- AOP의 목적은 횡단 관심사와 이에 영향받는 객체 간 결합도를 낮추는데 있다.

<img src="https://user-images.githubusercontent.com/26870393/182381535-d93c41eb-ab56-4d1f-bb24-df4732cb50a2.png">


