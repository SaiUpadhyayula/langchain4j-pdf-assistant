# PDF Assistant with Langchain4J, Spring Boot and AstraDB

This repository contains source code for the PDF Assistant application, that can answer questions based on the information contained in a given PDF.

It uses the LangChain4J framework to interact with OpenAI LLM, AstraDB to store the embeddings, and Spring Boot as the framework to create REST API.

Link to Video Tutorial: https://youtu.be/mvvRXu_KJSU

You can find the application running against Ollama with Llama3 and PGVector Embedding store in the branch - `ollama_with_pgvector`

Here is the question I asked our application
```text
What is cassandra, why to use Cassandra ?
```

And here is the answer provided by our application
```text
**What is Cassandra?**

Cassandra is a NoSQL, distributed, multi-master database management system designed to handle large amounts of data across many commodity servers with minimal overhead. It is a key-value store that can support high traffic and massive scalability.

**Why use Cassandra?**

Here are some reasons why you might choose to use Cassandra:

1. **Scalability**: Cassandra is designed to scale horizontally, meaning it can easily handle increasing loads by adding more nodes to the cluster.
2. **Fault Tolerance**: Cassandra is built to tolerate node failures and can continue running even if a significant number of nodes go down.
3. **High Throughput**: Cassandra can handle high traffic and large amounts of data with minimal latency.
4. **Flexibility**: Cassandra supports various data models, including key-value pairs, row-based data, and document-oriented data.
5. **Low Latency**: Cassandra is designed to minimize latency by allowing write operations to be executed in parallel across multiple nodes.

In summary, Cassandra is a great choice when you need a highly scalable, fault-tolerant, and performant database system that can handle large amounts of data and high traffic.
```