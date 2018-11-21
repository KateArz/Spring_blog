import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logg {

    @Before("execution(* blog.controllers.*.*(..))")
    public void logging(JoinPoint jp){
        System.out.println(jp.getSignature().getName());
        for(Object o : jp.getArgs()){
            System.out.println(o);
        }

    }
}
