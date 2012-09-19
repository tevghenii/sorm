package sorm.test

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import sorm.samples.TestingInstance
import sorm.Sorm.{Instance, Entity}
import util.Random
import org.joda.time.{DateTime, LocalDate}

object DeadlockTest {
  case class Album
    ( asin : String,
      name : String,
      artists : Seq[Artist],
      artistNames : Seq[String],
      format : String,
      tracklist : Seq[String],
      mp3s : Seq[Mp3],
      genres : Set[Genre],
      categories : Set[String],
      relatedAlbumsAsins : Seq[String],
      relatedArtists : Seq[Artist],
      rating : (Int, Int, Int, Int, Int),
      releaseDate : Option[LocalDate],
      originalReleaseDate : Option[LocalDate],
      copyright : Option[Copyright],
      label : Option[String],
      duration : Option[Int] )

  case class Copyright
    ( text : String,
      year : Short )

  case class Mp3
    ( asin : String,
      name : String,
      artists : Seq[Artist],
      duration : Option[Int] )

  case class Genre
    ( name : String )

  case class Artist
    ( asin : String,
      names : Seq[String] )

  case class Task
    ( asin : String,
      opened : DateTime,
      started : Option[DateTime] = None,
      closed : Option[DateTime] = None,
      failure : Option[String] = None )

}
@RunWith(classOf[JUnitRunner])
class DeadlockTest extends FunSuite with ShouldMatchers {
  import DeadlockTest._

//  def instance = TestingInstance.mysql(Entity[A](unique = Set() + Seq("a")), Entity[B]())
//
//  val db1 = instance
//  val db2 = instance
//  val db3 = instance
//
//  val a1 = db1.save(A(1))
//  val a2 = db1.save(A(3))
//  val a3 = db1.save(A(0))
//  val a4 = db1.save(A(3000))
//
//  db1.save(B(a2 :: a3 :: Nil))
//  db1.save(B(a3 :: Nil))
//  db1.save(B(a3 :: Nil))
//
//  db2.save(A(684))
//
//  db3.save(A(2))
//  db3.save(B(db3.save(A(4)) :: db3.save(A(6)) :: Nil))
//
//  test("Parallel transactions"){
//    val ops =
//      Seq(
//        (db : Instance) =>
//          db.transaction {
//            db.one[A].filterEqual("a", 3).fetch()
//              .map(_.copy(a = 3))
//              .map(db.save)
//          },
//        (db : Instance) =>
//          db.transaction {
//            db.all[B].fetch()
//          }
//      )
//    (0 until 100).view
//      .flatMap(_ => db1 :: db2 :: db3 :: Nil)
//      .map(db => { () => Random.shuffle(ops).head(db) } )
//      .par
//      .map(_())
//
////    .par.map{ db =>
////      db.transaction{
////        db.one[A].filterEqual("a", 3).fetch()
////          .map(_.copy(a = 3))
////          .map(db.save)
////      }
////    }
//
//  }
  test("Parallel saving"){
    pending
  }

}
