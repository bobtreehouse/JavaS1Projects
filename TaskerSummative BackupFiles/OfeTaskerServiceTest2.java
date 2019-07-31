// tasker service layer test #3 from Ofe


    TaskerServiceLayer service;
    TaskerDao taskerDao;
    RestTemplate restTemplate = new RestTemplate();
    DiscoveryClient discoveryClient;
    @Value("${adServerServiceName}")
    private String adServerServiceName = "adserver-service";
    @Value("${serviceProtocol}")
    private String serviceProtocol = "http://";
    @Value("${servicePath}")
    private String servicePath = "/ad";
    @Before
    public void setUp() throws Exception {
        setUpDiscoveryClientMock();
        setUpRestTemplateMock();
        setUpDaoMock();
        service = new TaskerServiceLayer(taskerDao,restTemplate,discoveryClient,adServerServiceName,serviceProtocol,servicePath);
    }
    @Test
    public void fetchAllTasks() {
        List<TaskViewModel> tasks = service.fetchAllTasks();
        assertEquals(tasks.size(), 1);
    }
    @Test
    public void fetchTasksByCategory() {
        List<TaskViewModel> tasks = service.fetchTasksByCategory("reminder");
        assertEquals(tasks.size(), 1);
    }
    @Test
    public void newAndFetchTask() {
        TaskViewModel task = new TaskViewModel();
        task.setCategory("reminder");
        task.setCreateDate(LocalDate.of(2012, 03, 05));
        task.setDescription("wash the dishes");
        task.setDueDate(LocalDate.of(2016, 02, 20));
        task = service.saveTask(task);
        TaskViewModel fromService = service.fetchTask(25);
    }
    private void setUpDaoMock(){
        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);
        Task taskMock = new Task();
        taskMock.setCategory("reminder");
        taskMock.setCreateDate(LocalDate.of(2012, 03, 05));
        taskMock.setDescription("wash the dishes");
        taskMock.setDueDate(LocalDate.of(2016, 02, 20));
        taskMock.setId(25);
        Task task = new Task();
        task.setCategory("reminder");
        task.setCreateDate(LocalDate.of(2012, 03, 05));
        task.setDescription("wash the dishes");
        task.setDueDate(LocalDate.of(2016, 02, 20));
        List<Task> list = new ArrayList<>();
        list.add(taskMock);
        doReturn(taskMock).when(taskerDao).createTask(task);
        doReturn(taskMock).when(taskerDao).getTask(25);
        doReturn(list).when(taskerDao).getTasksByCategory("reminder");
        doReturn(list).when(taskerDao).getAllTasks();
    }
    private void setUpRestTemplateMock() {
        restTemplate = mock(RestTemplate.class);
        doReturn("Nike sneakers available, click here").when(restTemplate).getForObject("http://localhost:6107/ad", String.class);
    }
    private void setUpDiscoveryClientMock() {
        discoveryClient = mock(DiscoveryClient.class);
        List<ServiceInstance> instances = new LinkedList<>();
        DefaultServiceInstance defaultServiceInstance = new DefaultServiceInstance("","","localhost",6107,true);
        instances.add(defaultServiceInstance);
        doReturn(instances).when(discoveryClient).getInstances("adserver-service");
    }
    private String createAd(){
        List<ServiceInstance> instances = discoveryClient.getInstances(adServerServiceName);
        String adServerServiceUri = serviceProtocol + instances.get(0).getHost() + ":" + instances.get(0).getPort() + servicePath + "ad";
        return restTemplate.getForObject(adServerServiceUri, String.class);
    }
}
