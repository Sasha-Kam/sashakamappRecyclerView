package com.example.sashakamapprecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val userList:List<User>): RecyclerView.Adapter<UserViewHolder>() { /* этот класс UserAdapter наследуется
от RecyclerView.Adapter. В угловые скобки <> помещается ViewHolder
Дальше надо имплементировать 3 функции

У Назв. класса нажать ALT+ENTER > Implement members, выделить все три > ENTER */

/* Кажд адаптер принимает в себя какой-то список, с которым будем работать.
В наш адаптер мы поместили вот этот (private val userList:List<User>) */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder { /* ф-ция
    создает отдельный объект для нашего ViewHolder'а. */

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_list_item, parent, false)
    /* создаем объект LayoutInflater
        (механизм, который на лету создает вьюшку. В конструктор ему кладем контекст.
        Так как мы находимся не в активити, адаптер не может прикинуться контекстом,
        поэтому мы вытаскиваем контекст из параметра parent: ViewGroup (см. стр 15)
        Далее выз ф-цию inflate, которая создаст вьюшку и наполняю ее параметрами:
        Параметр 1 - Resource (R), сюда кладем нашу верстку/ Обращаемся к ресурсам,
        версткам и доб верстку, которую мы создавали
        Параметр 2 - viewGroup, он у нас уже есть, его просто передаем
        Параметр 3 - false*/
        return UserViewHolder(itemView) /* возвращаем ViewHolder - сначала не хватает параметра itemView
        Это значит, нам надо натянуть нашу верстку на какую-то абстракт вьюшку
        и поместить ее в UserViewHolder. Мы созд val itemView. натянуть нашу верстку на какую-то абстракт вьюшку
        поможет LayoutInflater, который эту вьюшку itemView создает*/
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) { /* созд перем
    для кажд user'a. Т.е., когда RecyclerView будет отрисовывать эл-ты списка, RecyclerView будет выз
    ф-цию onBindViewHolder. */
        val user=userList[position] /* создать список юзеров и брать каждого юзера в зависимости от позиции.
        Позицию RecyclerView подставит сам по ходу пролисывания*/
        holder.bind(user) /* мы создали ViewHolder, теперь обращаемся к этому holder'у,
        вызываем ф-цию bind, которую создали, и положить в нее user'а*/
    }

    override fun getItemCount(): Int { /* функция, которая просит, чтобы мы вернули кол-во эл-тов в списке
    Обращаемся к списку и запрашиваем его size*/

        return userList.size
    }
}

// Когда адаптер создан, надо его прикрутить к RecyclerView
// click по item засовываем во VieцHolder, так как там мы работали с вьюшками. Достать там кнопку и задать клик по айтему