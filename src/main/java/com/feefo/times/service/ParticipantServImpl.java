package com.feefo.times.service;

import com.feefo.times.bl.Participant;
import com.feefo.times.dl.FormDataDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: broshanravan
 * Date: 24/06/13
 * Time: 11:58
 * To change this template use File | Settings | File Templates.
 */
public class ParticipantServImpl implements ParticipantServ {

    @Autowired
    FormDataDAOImpl formDataDAO;

    public int saveParticipant(Participant participant){
        int participantId=0;
        participantId= formDataDAO.saveParticipantDetail(participant);
        return participantId;

    }

    public boolean alreadyVoted(Participant participant){

        boolean voted = false;

        if(formDataDAO.emailExists(participant.getEmail())){
            voted= true;
        }

        return voted;

    }
}
