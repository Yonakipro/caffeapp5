package com.yonakipro.caffeapp5.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yonakipro.caffeapp5.R
import com.yonakipro.caffeapp5.payment.Payment

class PaymentListAdapter(
    private val onItemClickListener: (Payment) -> Unit
): ListAdapter<Payment, PaymentListAdapter.PaymentViewHolder>(WORDS_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
    return PaymentViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        val payment = getItem(position)
        holder.bind(payment)
        holder.itemView.setOnClickListener {
            onItemClickListener(payment)
        }
    }

    class PaymentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val nameOrderTextView: TextView = itemView.findViewById(R.id.nameOrderTextView)
        private val OrderTextView: TextView = itemView.findViewById(R.id.OrderTextView)
        private val addressTextView: TextView = itemView.findViewById(R.id.addressTextView)
        private val chargeTextView: TextView = itemView.findViewById(R.id.chargeTextView)

        fun bind(payment: Payment?) {
            nameOrderTextView.text = payment?.nameOrder
            OrderTextView.text = payment?.order
            addressTextView.text = payment?.address
            chargeTextView.text = payment?.charge

        }

        companion object {
            fun create(parent: ViewGroup): PaymentListAdapter.PaymentViewHolder {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_payment, parent, false)
                return PaymentViewHolder(view)
            }
        }
    }
    companion object {
        private val WORDS_COMPARATOR = object : DiffUtil.ItemCallback<Payment>(){
            override fun areItemsTheSame(oldItem: Payment, newItem: Payment): Boolean {
            return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Payment, newItem: Payment): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}