package com.programming.techie.pdfassistant;

import dev.langchain4j.chain.ConversationalRetrievalChain;
import dev.langchain4j.data.document.splitter.DocumentSplitters;
import dev.langchain4j.model.embedding.AllMiniLmL6V2EmbeddingModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.pgvector.PgVectorEmbeddingStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PdfAssistantConfig {
    @Bean
    public EmbeddingModel embeddingModel() {
        return new AllMiniLmL6V2EmbeddingModel();
    }

    @Bean
    public PgVectorEmbeddingStore pgVectorEmbeddingStore() {
        return PgVectorEmbeddingStore.builder()
                .host("localhost")
                .port(5432)
                .database("vectordb")
                .user("testuser")
                .password("testpwd")
                .table("test")
                .dimension(384)
                .build();
    }

    @Bean
    public EmbeddingStoreIngestor embeddingStoreIngestor() {
        return EmbeddingStoreIngestor.builder()
                .documentSplitter(DocumentSplitters.recursive(300, 0))
                .embeddingModel(embeddingModel())
                .embeddingStore(pgVectorEmbeddingStore())
                .build();
    }

    @Bean
    public ConversationalRetrievalChain conversationalRetrievalChain() {
        return ConversationalRetrievalChain.builder()
                .chatLanguageModel(OllamaChatModel.builder()
                        .baseUrl("http://localhost:11434")
                        .modelName("llama3")
                        .build())
                .contentRetriever(EmbeddingStoreContentRetriever.from(pgVectorEmbeddingStore()))
                .build();
    }
}
