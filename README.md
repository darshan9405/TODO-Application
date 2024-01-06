
# TODO-Application

The Todo Application is built on the Dropwizard framework, employing a MySQL database for seamless task management. Developed using Maven as the build tool, the Restful API interface offers endpoints designed to facilitate task creation, retrieval, modification, and deletion.




## API Reference

#### Get all tasks

```http
  GET /tasks
```

#### Get all tasks with status todo

```http
  GET /tasks?status=todo
```

#### Get all tasks with status work in progress

```http
  GET /tasks?status=wip
```

#### Get task with particular id

```http
  GET /tasks?id=
```
| Parameter | Description                       |
| :-------- | :-------------------------------- |
| `id`      | **Required**. Id of the task          |

#### Create new a task

```http
  POST /tasks
```

| Field         | Type     | Description                         |
| :-----------  | :------- | :-----------------------------------|
| `title`       | `string` | title of the task                   |
| `description` | `string` | description of the task             |
| `startDate`   | `string` | start timestamp of the task (default = current timestamp)        |
| `endDate` | `string` | end timestamp of the task           |
| `status` | `string` | status of the task (default = todo) |

#### Delete task with particular id

```http
  DELETE /tasks?id=
```

| Parameter | Description                       |
| :-------- | :-------------------------------- |
| `id`      | **Required**. Id of task to delete |


#### Modify a task

```http
  PATCH /tasks
```

| Field         | Type     | Description                         |
| :-----------  | :------- | :-----------------------------------|
|  `id`         | `string` | **Required** Id of the task to delete                                    |
| `title`       | `string` | title of the task                   |
| `description` | `string` | description of the task             |
| `startDate`   | `string` | start timestamp of the task         |
| `endDate` | `string` | end timestamp of the task           |
| `status` | `string` | status of the task  |

Note : Apart from Id only fields needed to be updated must be passed.