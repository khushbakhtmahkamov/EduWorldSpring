package com.example.eduworldspring.service;

import com.example.eduworldspring.exceptions.BusinessExceptionCode;
import com.example.eduworldspring.exceptions.BusinessRuntimeException;
import com.example.eduworldspring.model.TypeTask;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TypeTaskServiceImpl implements TypeTaskService {

    private static final Logger logger = LoggerFactory.getLogger(TypeTaskServiceImpl.class);

    private final List<TypeTask> typeTasks = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public TypeTask create(TypeTask typeTask) {
        try {
            logger.debug("Попытка создать TypeTask: {}", typeTask);

            validateTypeTaskForCreate(typeTask);

            // Устанавливаем ID, если он не установлен
            if (typeTask.getId() == null) {
                typeTask.setId(idGenerator.getAndIncrement());
            }

            // Проверяем, не существует ли уже TypeTask с таким ID
            if (existsById(typeTask.getId())) {
                logger.error("TypeTask с ID {} уже существует", typeTask.getId());
                throw new BusinessRuntimeException(
                        BusinessExceptionCode.BAD_REQUEST,
                        "TypeTask с ID " + typeTask.getId() + " уже существует"
                );
            }

            synchronized (typeTasks) {
                typeTasks.add(typeTask);
            }

            logger.info("Успешно создан TypeTask с ID: {}", typeTask.getId());
            return typeTask;

        } catch (BusinessRuntimeException e) {
            throw e;
        } catch (Exception e) {
            logger.error("Неожиданная ошибка при создании TypeTask", e);
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.COULD_NOT_SAVE,
                    "Не удалось сохранить TypeTask: " + e.getMessage()
            );
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            logger.debug("Попытка удалить TypeTask с ID: {}", id);

            validateId(id);

            synchronized (typeTasks) {
                for (int i = 0; i < typeTasks.size(); i++) {
                    TypeTask typeTask = typeTasks.get(i);
                    if (typeTask != null && typeTask.getId() != null && typeTask.getId().equals(id)) {
                        typeTasks.remove(i);
                        logger.info("Успешно удален TypeTask с ID: {}", id);
                        return true;
                    }
                }
            }

            logger.warn("TypeTask с ID {} не найден для удаления", id);
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.NOT_FOUND,
                    "TypeTask с ID " + id + " не найден"
            );

        } catch (BusinessRuntimeException e) {
            throw e;
        } catch (Exception e) {
            logger.error("Неожиданная ошибка при удалении TypeTask с ID: {}", id, e);
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.COULD_NOT_DELETE,
                    "Не удалось удалить TypeTask с ID " + id + ": " + e.getMessage()
            );
        }
    }

    @Override
    public TypeTask update(TypeTask typeTask) {
        try {
            logger.debug("Попытка обновить TypeTask: {}", typeTask);

            validateTypeTaskForUpdate(typeTask);

            synchronized (typeTasks) {
                for (int i = 0; i < typeTasks.size(); i++) {
                    TypeTask existingTask = typeTasks.get(i);
                    if (existingTask != null && existingTask.getId() != null &&
                            existingTask.getId().equals(typeTask.getId())) {
                        typeTasks.set(i, typeTask);
                        logger.info("Успешно обновлен TypeTask с ID: {}", typeTask.getId());
                        return typeTask;
                    }
                }
            }

            logger.error("TypeTask с ID {} не найден для обновления", typeTask.getId());
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.NOT_FOUND,
                    "TypeTask с ID " + typeTask.getId() + " не найден для обновления"
            );

        } catch (BusinessRuntimeException e) {
            throw e;
        } catch (Exception e) {
            logger.error("Неожиданная ошибка при обновлении TypeTask", e);
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.COULD_NOT_UPDATE,
                    "Не удалось обновить TypeTask: " + e.getMessage()
            );
        }
    }

    @Override
    public TypeTask getById(Long id) {
        try {
            logger.debug("Поиск TypeTask с ID: {}", id);

            validateId(id);

            synchronized (typeTasks) {
                for (TypeTask typeTask : typeTasks) {
                    if (typeTask != null && typeTask.getId() != null && typeTask.getId().equals(id)) {
                        logger.debug("Найден TypeTask с ID: {}", id);
                        return typeTask;
                    }
                }
            }

            logger.warn("TypeTask с ID {} не найден", id);
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.NOT_FOUND,
                    "TypeTask с ID " + id + " не найден"
            );

        } catch (BusinessRuntimeException e) {
            throw e;
        } catch (Exception e) {
            logger.error("Неожиданная ошибка при поиске TypeTask с ID: {}", id, e);
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.INTERNAL_ERROR,
                    "Ошибка при поиске TypeTask: " + e.getMessage()
            );
        }
    }

    @Override
    public List<TypeTask> getAll() {
        try {
            synchronized (typeTasks) {
                logger.debug("Получение всех TypeTask, количество: {}", typeTasks.size());
                return new ArrayList<>(typeTasks);
            }
        } catch (Exception e) {
            logger.error("Неожиданная ошибка при получении всех TypeTask", e);
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.INTERNAL_ERROR,
                    "Ошибка при получении списка TypeTask: " + e.getMessage()
            );
        }
    }

    //Проверяет существование TypeTask по ID
    private boolean existsById(Long id) {
        try {
            synchronized (typeTasks) {
                return typeTasks.stream()
                        .anyMatch(task -> task != null && task.getId() != null && task.getId().equals(id));
            }
        } catch (Exception e) {
            logger.error("Ошибка при проверке существования TypeTask с ID: {}", id, e);
            return false;
        }
    }

    //Валидация ID
    private void validateId(Long id) {
        if (id == null) {
            logger.error("Получен null ID");
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.BAD_REQUEST,
                    "ID не может быть null"
            );
        }

        if (id <= 0) {
            logger.error("Получен некорректный ID: {}", id);
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.BAD_REQUEST,
                    "ID должен быть положительным числом"
            );
        }
    }

    //Валидация TypeTask для создания
    private void validateTypeTaskForCreate(TypeTask typeTask) {
        if (typeTask == null) {
            logger.error("Попытка создать null TypeTask");
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.BAD_REQUEST,
                    "TypeTask не может быть null"
            );
        }

        validateTitle(typeTask.getTitle());
    }

    //Валидация TypeTask для обновления

    private void validateTypeTaskForUpdate(TypeTask typeTask) {
        if (typeTask == null) {
            logger.error("Попытка обновить null TypeTask");
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.BAD_REQUEST,
                    "TypeTask не может быть null"
            );
        }

        validateId(typeTask.getId());
        validateTitle(typeTask.getTitle());
    }

    private void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            logger.error("Получен пустой или null title");
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.BAD_REQUEST,
                    "Title не может быть null или пустым"
            );
        }

        if (title.length() > 255) {
            logger.error("Title слишком длинный: {} символов", title.length());
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.BAD_REQUEST,
                    "Title не может быть длиннее 255 символов"
            );
        }
    }

    //Очищает все TypeTask (для тестирования)

    public void clear() {
        try {
            synchronized (typeTasks) {
                typeTasks.clear();
                idGenerator.set(1);
                logger.info("Все TypeTask очищены");
            }
        } catch (Exception e) {
            logger.error("Ошибка при очистке TypeTask", e);
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.INTERNAL_ERROR,
                    "Не удалось очистить TypeTask: " + e.getMessage()
            );
        }
    }


    public int size() {
        try {
            synchronized (typeTasks) {
                return typeTasks.size();
            }
        } catch (Exception e) {
            logger.error("Ошибка при получении размера списка TypeTask", e);
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.INTERNAL_ERROR,
                    "Не удалось получить размер списка: " + e.getMessage()
            );
        }
    }
}