import java.util.Hashtable;

class TaskManager {
    class Manager {
        int userId;
        int taskId;
        int priority;

        public Manager(int userId, int taskId, int priority) {
            this.taskId = taskId;
            this.userId = userId;
            this.priority = priority;
        }
    }

    private Map<Integer, Manager> taskMap;
    PriorityQueue<Manager> pq;

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.priority == o2.priority) return o2.taskId - o1.taskId;
            return o2.priority - o1.priority;
        });

        for(List<Integer> task : tasks) {
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);

            Manager mg = new Manager(userId, taskId, priority);
            pq.offer(mg);
            taskMap.put(taskId, mg);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Manager mg = new Manager(userId, taskId, priority);
        pq.offer(mg);
        taskMap.put(taskId, mg);
    }
    
    public void edit(int taskId, int newPriority) {
        Manager oldMg = taskMap.get(taskId);
        Manager newMg = new Manager(oldMg.userId, taskId, newPriority);
        // pq.remove(oldMg);
        pq.offer(newMg);
        taskMap.put(taskId, newMg);
    }
    
    public void rmv(int taskId) {
        Manager rmvMg = taskMap.get(taskId);
        pq.remove(rmvMg);
        taskMap.remove(taskId);
    }
    
    public int execTop() {
        while (!pq.isEmpty()) {
            Manager top = pq.poll();
            Manager latest = taskMap.get(top.taskId);
            if (latest == null) continue; 
            if (latest.priority != top.priority) continue;
            taskMap.remove(top.taskId);
            return top.userId;
        }

        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */