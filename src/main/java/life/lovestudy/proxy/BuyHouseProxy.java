package life.lovestudy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BuyHouseProxy implements InvocationHandler {
	
	private Object target;
	
	public BuyHouseProxy(Object target) {
		this.target = target;
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		BuyHouseUtil.preBuy();      // 织入前期工作
		method.invoke(target, args);
		BuyHouseUtil.afterBuy();    // 织入后期工作
		return null;
	}
}
