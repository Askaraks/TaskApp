package com.example.taskapp.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskapp.databinding.ItemTaskBinding
import com.example.taskapp.model.Task

class TaskAdapter(
    var taskList: List<Task>,
    private var onLongClick:(Task) -> Unit,
    private val onTaskCheckChanged: (position: Int, isChecked: Boolean) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = taskList[position]
        holder.onBind(task,onTaskCheckChanged)

    }

    override fun getItemCount() = taskList.size


    inner  class TaskViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(task: Task, onTaskCheckChanged: (position: Int, isChecked: Boolean) -> Unit) {
            binding.tvTitle.text = task.title
            binding.check.isChecked = task.isDone

            binding.check.setOnCheckedChangeListener(null)
            binding.check.setOnCheckedChangeListener { _, isChecked ->
                onTaskCheckChanged(adapterPosition, isChecked)
            }
            itemView.setOnClickListener {
                onLongClick(task)
            }
        }
    }
}