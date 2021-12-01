package spring.task.university.service.mapper;

public interface ResponseDtoMapper<D, E> {
    D mapToDto(E e);
}
