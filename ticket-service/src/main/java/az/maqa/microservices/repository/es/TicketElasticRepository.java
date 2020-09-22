package az.maqa.microservices.repository.es;

import az.maqa.microservices.entity.es.TicketModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TicketElasticRepository extends ElasticsearchRepository<TicketModel, String> {

}
