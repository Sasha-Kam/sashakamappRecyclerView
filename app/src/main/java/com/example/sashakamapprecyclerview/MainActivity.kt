package com.example.sashakamapprecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
// Будем созд список с именами польз и возрастом
class MainActivity : AppCompatActivity() {

    lateinit var userRecyclerView : RecyclerView   /*1 этап: инициализир RecyclerView
    и затем находим его по id (См. стр 15) */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userList:List<User> = listOf(
            User("Ivan", 20),
            User("Elena", 19),
            User("Vasya", 35),
            User("Maksim",50)

        )

        userRecyclerView = findViewById(R.id.user_recycler_view)
        userRecyclerView.layoutManager = LinearLayoutManager (this, LinearLayoutManager.VERTICAL, false)

    /* 2 этап: пишем назв RecyclerView и присваиваем
        ему layoutManager. У LinearLayoutManager есть конструктор, в который нужно положить параметры
        Параметр 1 - контекст, в случае с активити указываем this
        Параметр 2 - orientation (вертикально или горизонтально). Мы пишем LinearLayoutManager
        Параметр 3 - reverseLayout (перевернуть или нет), у него булево знач-е, нам переворач не надо
        пишем false
        Так мы настроили LayoutManager - теперь все эл-ты списка будут расположены сверху вниз*/

    /* 3 этап: применяем адаптер для RecyclerView. Чтобы создать адаптер,
    надо создать для него ViewHolder, а для этого нужно сделать новый эл-т верстки

    4 этап: Так как у нас будут юзеры и у кажд будет аж по 2 поля (имя, возр),
    надо создать класс, в котором будем храить данные. Right-click на папку с кодом > New > Kotlin Class/File
     назвали User (будем работать с пользователями) */

    /* 5 этап: Прежде чем натягивать эл-ты на список,
    надо сначала натянуть данные на эл-ты списка. Для этого создаем ViewHolder.
    Создаем Kotlin Class/File, называем UserViewHolder
     */

    /* 6 этап: создаем Адаптер. Right-click на папку с кодом > New > Kotlin Class/File ->
    называем UserAdapter.
     */

    userRecyclerView.adapter = UserAdapter(userList) /* 7 этап: обращаемся к userRecyclerView и присваиваем знач-е
    адаптер UserAdapter. Не хватает списка пользователей. Создать его см стр 15*/
    userRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL)) /*
    добавляем линию-отделитель */

    }
}

// Надо сделать:
// RecyclerView (done1) <- Adapter (done) <- ViewHolder (done) <- layout (done2)
// Спискок с пользователями - done
/*Мы создавали свой тип данных, так как в списке у нас целых 2 параметра. Если будут только имена или картинки и т.п.,
можно просто создать list of Strings, заполнить его и не создавать свой тип данных */

// 2 параметра RecyclerView:
// 1) LayoutManager - LinearLayoutManager или GridLayoutManager (чтобы вынести в неск. столбцов). Мы будем польз. Linear
// 2) Adapter - это механизм, который натягивает эл-ты на список.
// ViewHolder - это механизм, который натягивает данные на эл-ты
// Layout - это сам элемент. Он может быть в виде карточки, картинки, кнопочек, текст с кнопочками