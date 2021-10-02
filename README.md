https://www.youtube.com/watch?v=q87Xxu4NPIc

Полезное 

Gradl
ResponseEntity в @RestController
@OneToMany @ManyToOne
Возвращает модел пользователя без пороля


userModel.setTodo(userEntity.getTodoList().stream().map(TodoModel::todoModel).collect(Collectors.toList()));
преобразоыываем список в stream, вызываем у него мар. 
дальше выполняется функия todoModel для каждого элемента массива 
Коллектом преобразовываем обратно к листу
Итог: преобразование масива entity в масив моделей через итерацию

Миграция баз данных (не работатет, возможно из-за зависимостей)