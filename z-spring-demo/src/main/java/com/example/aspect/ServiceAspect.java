package com.example.aspect;

import com.example.aspect.introduction.LittleUniverse;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author JiaHao Wang
 * @date 8/15/22 2:01 PM
 */
@Aspect
@Component
@EnableAspectJAutoProxy
public class ServiceAspect {

	/**
	 * 这样子我们便赋予了每个Controller都能变身为littleUniverse的权力
	 */
	@DeclareParents(value = "com.example.controller..*", defaultImpl = com.example.aspect.introduction.impl.LittleUniverseImpl.class)
	public LittleUniverse littleUniverse;
}
