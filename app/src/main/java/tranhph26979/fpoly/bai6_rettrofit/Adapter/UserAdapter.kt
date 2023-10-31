package tranhph26979.fpoly.bai6_rettrofit.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import tranhph26979.fpoly.bai6_rettrofit.R
import tranhph26979.fpoly.bai6_rettrofit.model.UserModel

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private var userList: List<UserModel> = emptyList()

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.tv_nameuser)
        private val emailTextView: TextView = itemView.findViewById(R.id.tv_email)
        private val locationTextView:TextView=itemView.findViewById(R.id.tv_location)
        private val dateTextView:TextView=itemView.findViewById(R.id.tv_date)
        private val ageTextView:TextView=itemView.findViewById(R.id.tv_age)
        private val gendertextview:TextView=itemView.findViewById(R.id.tv_gender)
        private val phoneTextView:TextView=itemView.findViewById(R.id.tv_phone)
        private val cellTextView:TextView=itemView.findViewById(R.id.tv_cell)
        private val natTextView:TextView=itemView.findViewById(R.id.tv_nat)
        private val userImage:ImageView=itemView.findViewById(R.id.userImage)

        fun bind(user: UserModel) {
            nameTextView.text ="Name: "+ "${user.name.title} ${user.name.first} ${user.name.last}"
            emailTextView.text = "Email: "+user.email
            locationTextView.text="Location: ${user.location.street.number}, ${user.location.street.name}, ${user.location.city}, ${user.location.state}, ${user.location.country}, ${user.location.postcode}"
            dateTextView.text="Date: "+user.dob.date
            ageTextView.text="Age: "+user.dob.age.toString()
            gendertextview.text="Gender: "+user.gender
            phoneTextView.text="Phone: "+user.phone
            cellTextView.text="Cell: "+user.cell
            natTextView.text="Nat: "+user.nat
            Picasso.get().load(user.picture.large).into(userImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setUserList(users: List<UserModel>) {
        userList = users
        notifyDataSetChanged()
    }
}