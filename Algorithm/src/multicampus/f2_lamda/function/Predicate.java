package multicampus.f2_lamda.function;

@FunctionalInterface
public interface Predicate<T> {
	boolean test(T t);
}
