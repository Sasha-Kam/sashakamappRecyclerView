package com.example.sashakamapprecyclerview

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class UserViewHolder(itemView: View):RecyclerView.ViewHolder (itemView){ /*этот класс - наследник RecyclerView.ViewHolder,
а RecyclerView.ViewHolder обязательно хранит в себе какую-то вьюшку. Для этой вьюшки
 в будущем будет использоваться layout, к-рый мы создали (user_list_item) */

    private val nameTextView : TextView = itemView.findViewById(R.id.name_text_view)
    private val ageTextView :TextView = itemView.findViewById(R.id.age_text_view)/* Для нашего списка есть 2 вьюшки: nameTextView и ageTextView.
        Каждую из них надо вытянуть по id. Но, поскольку мы не внутри активити, мы не можем написать findViewById/
        Надо искать по id из itemView. Этот itemView - это вьюшка, на которую натянута наша верстка.
        itemView - это обязательный параметр ViewHolder'а. Мы его пропишем в Адаптере, когда будем его создавать */

    fun bind (user:User) { /* создаем ф-цию bind, которая будет связывать (натягивать) данные.
    Эта ф-ция будет принимать в себя юзера user:User) */


        nameTextView.text="Имя - ${user.name}" /* нам нужно сменить знач-е текста. И мы будем
        обращаться к полям нашего класса User. Здесь мы буквально написали, что просим (с пом. знака $) подставить
         в текстовое поле значение name из User. user.name - работаем с data class User*/
        ageTextView.text="Возраст - ${user.age}" /* то же сделали для возраста
        Эта запись со знаком $ означ., что надо преобраз данные в String и поместить в это поле */

    itemView.setOnClickListener {
        Toast.makeText(itemView.context, user.name, Toast.LENGTH_LONG).show()
    }
    }
}