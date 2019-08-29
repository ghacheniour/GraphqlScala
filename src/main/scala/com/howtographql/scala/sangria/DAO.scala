package com.howtographql.scala.sangria

import DBSchema._
import models._
import scala.concurrent.Future
import slick.jdbc.H2Profile.api._

class DAO(db: Database) {
  def allLinks = db.run(Links.result)
  def getLinks(ids: Seq[Int]) = db.run(Links.filter(_.id inSet ids).result)
  def getUsers(ids: Seq[Int]) = db.run(Users.filter(_.id inSet ids).result)
  def getVotes(ids: Seq[Int]) = db.run(Votes.filter(_.id inSet ids).result)
  def getLinksByUserIds(ids: Seq[Int]) = db.run(Links.filter(_.postedBy inSet ids).result)
  def getVotesByUserIds(ids: Seq[Int]) = db.run(Votes.filter(_.userId inSet ids).result)
}
