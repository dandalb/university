package spring.task.university.service.mapper;

public interface RequestDtoMapper<E, D> {
    E mapToModel(D dto);
}
