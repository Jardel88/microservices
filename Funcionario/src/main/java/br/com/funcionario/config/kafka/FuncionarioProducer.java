package br.com.funcionario.config.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.funcionario.domain.dto.FuncionarioDTO;



@Service
public class FuncionarioProducer {
	
	private static final Logger logger = LoggerFactory.getLogger(FuncionarioProducer.class);//Pesquisar mais sobre Sl4j
	private final String topic;
	private final KafkaTemplate<String, FuncionarioDTO> kafkaTemplate;

	public FuncionarioProducer(@Value("${topic.name}") String topic,KafkaTemplate<String, FuncionarioDTO> kafkaTemplate) {
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void send(FuncionarioDTO funcionarioDTO) {
		kafkaTemplate.send(topic, funcionarioDTO).addCallback(
					success -> logger.info("Message send: " + success.getProducerRecord().value()),
					failure -> logger.info("message failure: " + failure.getMessage())
				);
	}

}
