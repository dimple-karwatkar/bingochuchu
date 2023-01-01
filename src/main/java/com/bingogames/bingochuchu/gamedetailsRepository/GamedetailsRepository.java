package com.bingogames.bingochuchu.gamedetailsRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bingogames.bingochuchu.gamedetailsmodel.GameDetails;

public interface GamedetailsRepository extends MongoRepository<GameDetails,String> {

}
