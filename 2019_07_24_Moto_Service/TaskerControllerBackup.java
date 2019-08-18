
public class TaskerController {


    @Autowired
    TaskerDao taskerDao;

    @Autowired
    TaskerServiceLayer service;

    public TaskerController(TaskerServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/tasks{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }


    @RequestMapping (value = "/tasks{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public TaskViewModel getTask(@PathVariable int id)  {

        return service.fetchTask(id);
    }

    @RequestMapping (value = "/tasks{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TaskViewModel> getAllTasks()  {

        return service.fetchAllTasks();
    }

    @RequestMapping (value = "/tasks{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TaskViewModel> getTasksByCategory(String category)  {

        return service.fetchTasksByCategory(category);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public TaskViewModel createTask(@RequestBody @Valid TaskViewModel task) {
        service.saveTask(task);

        return task;
    }

    @RequestMapping(value = "/tasks{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void updateTask(@PathVariable TaskViewModel task) {
        service.updateTask(task);
    }

    @RequestMapping(value = "/ad", method = RequestMethod.GET)
    public String getAd() {
        return advertisement();
    }

    private String advertisement() {
        return null;
    }
}
