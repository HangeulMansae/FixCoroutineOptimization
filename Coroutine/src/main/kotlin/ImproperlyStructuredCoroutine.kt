package org.example

import kotlinx.coroutines.*

// 병렬 작업하기
fun main(): Unit = runBlocking{
    val list = listOf(
        listOf("작업 1", "작업 1-1", "작업 1-2", "작업 1-3", "작업 1-4", "작업 1-5"),
        listOf("작업 2", "작업 2-1", "작업 2-2", "작업 2-3", "작업 2-4", "작업 2-5"),
        listOf("작업 3", "작업 3-1", "작업 3-2", "작업 3-3", "작업 3-4", "작업 3-5"),
        listOf("작업 4", "작업 4-1", "작업 4-2", "작업 4-3", "작업 4-4", "작업 4-5"),
        listOf("작업 5", "작업 5-1", "작업 5-2", "작업 5-3", "작업 5-4", "작업 5-5"),
        listOf("작업 6", "작업 6-1", "작업 6-2", "작업 6-3", "작업 6-4", "작업 6-5"),
        listOf("작업 7", "작업 7-1", "작업 7-2", "작업 7-3", "작업 7-4", "작업 7-5"),
        listOf("작업 8", "작업 8-1", "작업 8-2", "작업 8-3", "작업 8-4", "작업 8-5"),
        listOf("작업 9", "작업 9-1", "작업 9-2", "작업 9-3", "작업 9-4", "작업 9-5"),
        listOf("작업 10", "작업 10-1", "작업 10-2", "작업 10-3", "작업 10-4", "작업 10-5"),
        listOf("작업 11", "작업 11-1", "작업 11-2", "작업 11-3", "작업 11-4", "작업 11-5"),
        listOf("작업 12", "작업 12-1", "작업 12-2", "작업 12-3", "작업 12-4", "작업 12-5"),
        listOf("작업 13", "작업 13-1", "작업 13-2", "작업 13-3", "작업 13-4", "작업 13-5"),
        listOf("작업 14", "작업 14-1", "작업 14-2", "작업 14-3", "작업 14-4", "작업 14-5"),
        listOf("작업 15", "작업 15-1", "작업 15-2", "작업 15-3", "작업 15-4", "작업 15-5"),
        listOf("작업 16", "작업 16-1", "작업 16-2", "작업 16-3", "작업 16-4", "작업 16-5"),
        listOf("작업 17", "작업 17-1", "작업 17-2", "작업 17-3", "작업 17-4", "작업 17-5"),
        listOf("작업 18", "작업 18-1", "작업 18-2", "작업 18-3", "작업 18-4", "작업 18-5"),
        listOf("작업 19", "작업 19-1", "작업 19-2", "작업 19-3", "작업 19-4", "작업 19-5"),
        listOf("작업 20", "작업 20-1", "작업 20-2", "작업 20-3", "작업 20-4", "작업 20-5"),
    )
    withContext(Dispatchers.IO){
        val job1 = list.chunked(5).map {
            launch {
                it.forEach {
                    withContext(Dispatchers.IO) {
                        val task1 = launch {
                            println(it[1])
                        }
                        val task2 = launch {
                            println(it[2])
                        }
                        val task3 = launch {
                            println(it[3])
                        }
                        val task4 = launch {
                            println(it[4])
                        }
                        val task5 = launch {
                            println(it[5])
                        }
                        // 어차피 join 한 뒤에 처리할 것도 없어서 joinAll을 쓰는 의미가 없다.
                        joinAll(task1, task2, task3, task4, task5)
                    }
                }
            }
        }
        // 모든 청크들을 다 코루틴으로 만든 뒤에야 joinAll을 통해 기다리는 것이므로 그냥 청크를 나눈 의미가 없어진다.
        job1.joinAll()
    }
}