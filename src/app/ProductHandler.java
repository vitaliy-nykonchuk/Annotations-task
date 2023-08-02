package app;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class ProductHandler {

    public static void main(String[] args) throws NoSuchMethodException {
        Class<ProductInfo> infoClass = ProductInfo.class;
        getAnnot(infoClass);
        Method method = infoClass.getDeclaredMethod("getData");
        getAnnot(method);
    }

    static void getAnnot(AnnotatedElement element) {

        try {
            Annotation[] annotations = element.getAnnotations();

            for (Annotation annotation : annotations) {
                if (annotation instanceof Product product) {
                    System.out.printf("Product: %s, quota: %d%n",
                            product.name(), product.quota());
                }
            }
        } catch (Exception ignored) {
        }
    }
}
