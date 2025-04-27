import task

class TaskService1:
    def __init__(self):
        self.tasks = dict()

    def addTask(self, task):
        self.tasks.update({task.taskId: task})

    def deleteTask(self, taskId):
        del self.tasks[taskId]

    def getTask(self, taskId):
        return self.tasks[taskId]