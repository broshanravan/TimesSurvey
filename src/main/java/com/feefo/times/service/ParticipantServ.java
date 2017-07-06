package com.feefo.times.service;

import com.feefo.times.bl.Participant;

/**
 * Created with IntelliJ IDEA.
 * User: broshanravan
 * Date: 24/06/13
 * Time: 11:57
 * To change this template use File | Settings | File Templates.
 */
public interface ParticipantServ {
   public int saveParticipant(Participant participant);

   public boolean alreadyVoted(Participant participant) ;
}
