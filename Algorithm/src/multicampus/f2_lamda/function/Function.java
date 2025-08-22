package multicampus.f2_lamda.function;

@FunctionalInterface
public interface Function<T, R> {
	R apply(T arg, T arg2);
}
