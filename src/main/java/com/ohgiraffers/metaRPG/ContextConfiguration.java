package com.ohgiraffers.metaRPG;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
// 컴포넌트로 되어 있는 클래스들을 객체 생성 후 저장
@ComponentScan(basePackages = {"com.ohgiraffers.metaRPG"})
public class ContextConfiguration {
}
