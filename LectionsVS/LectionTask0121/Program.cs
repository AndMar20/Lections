//Параллельное ассинхронное программирование
#region
//Task[] tasks = new Task[]
//{
//    new Task(()=>Console.WriteLine("Hello 1")),
//    new Task(()=>Console.WriteLine("Hello 2")),
//    new Task(()=>Console.WriteLine("Hello 3"))
//};
//foreach (var task in tasks)
//{
//    task.Start();
//}
//Task.WaitAll(tasks);
#endregion

#region
//Task[] tasks1 = new Task[3];
//int j = 0;
//for (int i = 0; i< tasks1.Length; i++)
//{
//    tasks1[i] = Task.Factory.StartNew(()=>Console.WriteLine($"Hello Task {++j}"));
//}
//Task.WaitAll(tasks1); // Ожидание всех задач
//Task.WaitAny(tasks1); // Ожидание хотя бы одной задачи


//Task<int> sumTask = new Task<int>(() => 2 + 2); // Задача выдает результат
//sumTask.Start();

//int result1 = sumTask.Result;
//int result2 = await sumTask;
//Console.WriteLine(result1);
//Console.WriteLine(result2);
#endregion

#region Задачи возвращают 4 типа значений
////Task низкие уровни операци
////Task async await Высокие уровни операций
//static async void Print1Async() // для асинхронных обработчиков событий
//{ 

//}
//static async Task Print2Async()
//{

//}

//static async Task<int> Print3Async() // Task который возвращает некоторое значение
//{
//    return 2 + 2;
//}

//static async ValueTask<int> Print4Async() // Значимый объект
//{
//    return 2 + 2;
//}
#endregion

#region Отмена задач
//CancellationTokenSource cts = new CancellationTokenSource();//источник токена который позволит отменять задачи
//CancellationToken token = cts.Token;//для отмены задачи
////при запуске задачи
//Task task1 = new Task(() =>
//{
//    for (int i = 0; i < 10; i++)
//    {
//        token.Register(() => //Тоже отменяет задачу
//        {
//            Console.WriteLine("Галя отмена!");
//        });

//        if (token.IsCancellationRequested) //Запрошена ли отмена задачи
//        {
//            Console.WriteLine("Галя отмена!");
//            //return; или:
//            token.ThrowIfCancellationRequested();// выброс исключения если операция была отменена
//        }
//        Console.WriteLine(i);
//        Thread.Sleep(200);
//    }
//}, token);

//task1.Start();
//Thread.Sleep(1000);
//cts.Cancel();//Запрашиваем отмену задачи
//Thread.Sleep(1000);
//Console.WriteLine(task1.Status);

//cts.Dispose();
#endregion

#region Таймеры
using System.Timers;

System.Threading.Timer timer = new(obj => Console.WriteLine("Hello"));

System.Timers.Timer timer2 = new(1000);
timer2.Start();
timer2.Elapsed += Timer2_Elapsed;

void Timer2_Elapsed(object? sender, ElapsedEventArgs e)
{
    throw new NotImplementedException();
}

Thread.Sleep(10000);
timer2.Stop();

//System.Windows.Forms.Timer; В Формс
//System.Web.UI.Timer; В Браузере
//System.Windows.Threading.DispatcherTimer; В ВПФ
#endregion
