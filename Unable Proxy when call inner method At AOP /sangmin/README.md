# Unable Proxy when call inner method At AOP

## Unable Proxy when call inner method At AOP

---

👾 AOP 적용시, 내부메서드 호출했을때, 프록시객체가 아닌 실제 대상객체를 사용하는 문제

> AOP 적용시, 스프링은 실제객체 대신 프록시를 스프링 빈으로 등록하고, 따라서 프록시 객체를 사용한다 <br>
문제는, 객체 내부에서 메서드를 호출하게 되면, 프록시가 아닌 실제 대상객체가 호출되는 현상이 발생한다!
>

## 시나리오

---

2주차 JPA-DirtyChecking Performance Issue 문제를 바탕으로 합니다. 문제상황은 다음과 같습니다

- Content 엔티티를 조회해 수정하는 메서드 내부에서 실제로 수정하는 로직의 메서드를 호출합니다
- 수정하는 메서드는 엔티티를 불러오는 메서드 내부에서 실행됩니다
- 테스트에서 사용했던 ExcutionTimer를 AOP로 사용합니다

## Problem

---

가정한 문제가 발생했나요?

- 호출대상객체가 프록시인지 실제대상객체인지 로그를 통한 검증

## Solution

---

### 1. 자기자신 주입
- 객체 내부메서드 사용시 자기자신 주입해 사용

### 2. 지연조회
- Provider
- ApplicationContext

### 3. 구조변경


// point
1. Setter를 쓰지 않아야하는 이유
2. 프록시를 쓰는 이유
3. 프록시 실행 시점 (동작방식)
4. AOP를 사용하는 이유
5. AOP 동작방식