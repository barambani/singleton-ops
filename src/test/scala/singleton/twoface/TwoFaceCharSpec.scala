package singleton.twoface

import org.scalacheck.Properties
import singleton.TestUtils._
import singleton.ops._

class TwoFaceCharSpec extends Properties("TwoFace.Char") {
  property("Implicit Creation[]") = {
    val a = implicitly[TwoFace.Char['\u0002']]
    a.getValue == '\u0002' && a.isLiteral
  }
  property("Safe Creation[]") = {
    val a = TwoFace.Char['\u0002']
    a.getValue == '\u0002' && a.isLiteral
  }
  property("Safe Creation()") = {
    val a = TwoFace.Char('\u0002')
    a.getValue == '\u0002' && a.isLiteral
  }
  property("Unsafe Creation()") = {
    val a = TwoFace.Char(us('\u0002'))
    a.getValue == '\u0002' && !a.isLiteral
  }

  property("Safe ifThenElse") = verifyTF(ifThenElse(true, '\u0001', '\u0002'), '\u0001')
  property("Unsafe ifThenElse") = verifyTF(ifThenElse(us(false), '\u0001', '\u0002'), us('\u0002'))

  property("Safe Char + Safe Char") = verifyTF(TwoFace.Char('\u0002') + TwoFace.Char('\u0001'), 3)
  property("Safe Char + Unsafe Char") = verifyTF(TwoFace.Char('\u0002') + TwoFace.Char(us('\u0001')), us(3))
  property("Unsafe Char + Safe Char") = verifyTF(TwoFace.Char(us('\u0002')) + TwoFace.Char('\u0001'), us(3))
  property("Unsafe Char + Unsafe Char") = verifyTF(TwoFace.Char(us('\u0002')) + TwoFace.Char(us('\u0001')), us(3))
  property("Safe Char + Safe Int") = verifyTF(TwoFace.Char('\u0002') + TwoFace.Int(1), 3)
  property("Safe Char + Unsafe Int") = verifyTF(TwoFace.Char('\u0002') + TwoFace.Int(us(1)), us(3))
  property("Unsafe Char + Safe Int") = verifyTF(TwoFace.Char(us('\u0002')) + TwoFace.Int(1), us(3))
  property("Unsafe Char + Unsafe Int") = verifyTF(TwoFace.Char(us('\u0002')) + TwoFace.Int(us(1)), us(3))
  property("Safe Char + Safe Long") = verifyTF(TwoFace.Char('\u0002') + TwoFace.Long(1L), 3L)
  property("Safe Char + Unsafe Long") = verifyTF(TwoFace.Char('\u0002') + TwoFace.Long(us(1L)), us(3L))
  property("Unsafe Char + Safe Long") = verifyTF(TwoFace.Char(us('\u0002')) + TwoFace.Long(1L), us(3L))
  property("Unsafe Char + Unsafe Long") = verifyTF(TwoFace.Char(us('\u0002')) + TwoFace.Long(us(1L)), us(3L))
  property("Safe Char + Safe Float") = verifyTF(TwoFace.Char('\u0002') + TwoFace.Float(1.0f), 3.0f)
  property("Safe Char + Unsafe Float") = verifyTF(TwoFace.Char('\u0002') + TwoFace.Float(us(1.0f)), us(3.0f))
  property("Unsafe Char + Safe Float") = verifyTF(TwoFace.Char(us('\u0002')) + TwoFace.Float(1.0f), us(3.0f))
  property("Unsafe Char + Unsafe Float") = verifyTF(TwoFace.Char(us('\u0002')) + TwoFace.Float(us(1.0f)), us(3.0f))
  property("Safe Char + Safe Double") = verifyTF(TwoFace.Char('\u0002') + TwoFace.Double(1.0), 3.0)
  property("Safe Char + Unsafe Double") = verifyTF(TwoFace.Char('\u0002') + TwoFace.Double(us(1.0)), us(3.0))
  property("Unsafe Char + Safe Double") = verifyTF(TwoFace.Char(us('\u0002')) + TwoFace.Double(1.0), us(3.0))
  property("Unsafe Char + Unsafe Double") = verifyTF(TwoFace.Char(us('\u0002')) + TwoFace.Double(us(1.0)), us(3.0))

  property("Safe Char - Safe Char") = verifyTF(TwoFace.Char('\u0002') - TwoFace.Char('\u0001'), 1)
  property("Safe Char - Unsafe Char") = verifyTF(TwoFace.Char('\u0002') - TwoFace.Char(us('\u0001')), us(1))
  property("Unsafe Char - Safe Char") = verifyTF(TwoFace.Char(us('\u0002')) - TwoFace.Char('\u0001'), us(1))
  property("Unsafe Char - Unsafe Char") = verifyTF(TwoFace.Char(us('\u0002')) - TwoFace.Char(us('\u0001')), us(1))
  property("Safe Char - Safe Int") = verifyTF(TwoFace.Char('\u0002') - TwoFace.Int(1), 1)
  property("Safe Char - Unsafe Int") = verifyTF(TwoFace.Char('\u0002') - TwoFace.Int(us(1)), us(1))
  property("Unsafe Char - Safe Int") = verifyTF(TwoFace.Char(us('\u0002')) - TwoFace.Int(1), us(1))
  property("Unsafe Char - Unsafe Int") = verifyTF(TwoFace.Char(us('\u0002')) - TwoFace.Int(us(1)), us(1))
  property("Safe Char - Safe Long") = verifyTF(TwoFace.Char('\u0002') - TwoFace.Long(1L), 1L)
  property("Safe Char - Unsafe Long") = verifyTF(TwoFace.Char('\u0002') - TwoFace.Long(us(1L)), us(1L))
  property("Unsafe Char - Safe Long") = verifyTF(TwoFace.Char(us('\u0002')) - TwoFace.Long(1L), us(1L))
  property("Unsafe Char - Unsafe Long") = verifyTF(TwoFace.Char(us('\u0002')) - TwoFace.Long(us(1L)), us(1L))
  property("Safe Char - Safe Float") = verifyTF(TwoFace.Char('\u0002') - TwoFace.Float(1.0f), 1.0f)
  property("Safe Char - Unsafe Float") = verifyTF(TwoFace.Char('\u0002') - TwoFace.Float(us(1.0f)), us(1.0f))
  property("Unsafe Char - Safe Float") = verifyTF(TwoFace.Char(us('\u0002')) - TwoFace.Float(1.0f), us(1.0f))
  property("Unsafe Char - Unsafe Float") = verifyTF(TwoFace.Char(us('\u0002')) - TwoFace.Float(us(1.0f)), us(1.0f))
  property("Safe Char - Safe Double") = verifyTF(TwoFace.Char('\u0002') - TwoFace.Double(1.0), 1.0)
  property("Safe Char - Unsafe Double") = verifyTF(TwoFace.Char('\u0002') - TwoFace.Double(us(1.0)), us(1.0))
  property("Unsafe Char - Safe Double") = verifyTF(TwoFace.Char(us('\u0002')) - TwoFace.Double(1.0), us(1.0))
  property("Unsafe Char - Unsafe Double") = verifyTF(TwoFace.Char(us('\u0002')) - TwoFace.Double(us(1.0)), us(1.0))

  property("Safe Char * Safe Char") = verifyTF(TwoFace.Char('\u0002') * TwoFace.Char('\u0001'), 2)
  property("Safe Char * Unsafe Char") = verifyTF(TwoFace.Char('\u0002') * TwoFace.Char(us('\u0001')), us(2))
  property("Unsafe Char * Safe Char") = verifyTF(TwoFace.Char(us('\u0002')) * TwoFace.Char('\u0001'), us(2))
  property("Unsafe Char * Unsafe Char") = verifyTF(TwoFace.Char(us('\u0002')) * TwoFace.Char(us('\u0001')), us(2))
  property("Safe Char * Safe Int") = verifyTF(TwoFace.Char('\u0002') * TwoFace.Int(1), 2)
  property("Safe Char * Unsafe Int") = verifyTF(TwoFace.Char('\u0002') * TwoFace.Int(us(1)), us(2))
  property("Unsafe Char * Safe Int") = verifyTF(TwoFace.Char(us('\u0002')) * TwoFace.Int(1), us(2))
  property("Unsafe Char * Unsafe Int") = verifyTF(TwoFace.Char(us('\u0002')) * TwoFace.Int(us(1)), us(2))
  property("Safe Char * Safe Long") = verifyTF(TwoFace.Char('\u0002') * TwoFace.Long(1L), 2L)
  property("Safe Char * Unsafe Long") = verifyTF(TwoFace.Char('\u0002') * TwoFace.Long(us(1L)), us(2L))
  property("Unsafe Char * Safe Long") = verifyTF(TwoFace.Char(us('\u0002')) * TwoFace.Long(1L), us(2L))
  property("Unsafe Char * Unsafe Long") = verifyTF(TwoFace.Char(us('\u0002')) * TwoFace.Long(us(1L)), us(2L))
  property("Safe Char * Safe Float") = verifyTF(TwoFace.Char('\u0002') * TwoFace.Float(1.0f), 2.0f)
  property("Safe Char * Unsafe Float") = verifyTF(TwoFace.Char('\u0002') * TwoFace.Float(us(1.0f)), us(2.0f))
  property("Unsafe Char * Safe Float") = verifyTF(TwoFace.Char(us('\u0002')) * TwoFace.Float(1.0f), us(2.0f))
  property("Unsafe Char * Unsafe Float") = verifyTF(TwoFace.Char(us('\u0002')) * TwoFace.Float(us(1.0f)), us(2.0f))
  property("Safe Char * Safe Double") = verifyTF(TwoFace.Char('\u0002') * TwoFace.Double(1.0), 2.0)
  property("Safe Char * Unsafe Double") = verifyTF(TwoFace.Char('\u0002') * TwoFace.Double(us(1.0)), us(2.0))
  property("Unsafe Char * Safe Double") = verifyTF(TwoFace.Char(us('\u0002')) * TwoFace.Double(1.0), us(2.0))
  property("Unsafe Char * Unsafe Double") = verifyTF(TwoFace.Char(us('\u0002')) * TwoFace.Double(us(1.0)), us(2.0))

  property("Safe Char / Safe Char") = verifyTF(TwoFace.Char('\u0006') / TwoFace.Char('\u0002'), 3)
  property("Safe Char / Unsafe Char") = verifyTF(TwoFace.Char('\u0006') / TwoFace.Char(us('\u0002')), us(3))
  property("Unsafe Char / Safe Char") = verifyTF(TwoFace.Char(us('\u0006')) / TwoFace.Char('\u0002'), us(3))
  property("Unsafe Char / Unsafe Char") = verifyTF(TwoFace.Char(us('\u0006')) / TwoFace.Char(us('\u0002')), us(3))
  property("Safe Char / Safe Int") = verifyTF(TwoFace.Char('\u0006') / TwoFace.Int(2), 3)
  property("Safe Char / Unsafe Int") = verifyTF(TwoFace.Char('\u0006') / TwoFace.Int(us(2)), us(3))
  property("Unsafe Char / Safe Int") = verifyTF(TwoFace.Char(us('\u0006')) / TwoFace.Int(2), us(3))
  property("Unsafe Char / Unsafe Int") = verifyTF(TwoFace.Char(us('\u0006')) / TwoFace.Int(us(2)), us(3))
  property("Safe Char / Safe Long") = verifyTF(TwoFace.Char('\u0006') / TwoFace.Long(2L), 3L)
  property("Safe Char / Unsafe Long") = verifyTF(TwoFace.Char('\u0006') / TwoFace.Long(us(2L)), us(3L))
  property("Unsafe Char / Safe Long") = verifyTF(TwoFace.Char(us('\u0006')) / TwoFace.Long(2L), us(3L))
  property("Unsafe Char / Unsafe Long") = verifyTF(TwoFace.Char(us('\u0006')) / TwoFace.Long(us(2L)), us(3L))
  property("Safe Char / Safe Float") = verifyTF(TwoFace.Char('\u0006') / TwoFace.Float(2.0f), 3.0f)
  property("Safe Char / Unsafe Float") = verifyTF(TwoFace.Char('\u0006') / TwoFace.Float(us(2.0f)), us(3.0f))
  property("Unsafe Char / Safe Float") = verifyTF(TwoFace.Char(us('\u0006')) / TwoFace.Float(2.0f), us(3.0f))
  property("Unsafe Char / Unsafe Float") = verifyTF(TwoFace.Char(us('\u0006')) / TwoFace.Float(us(2.0f)), us(3.0f))
  property("Safe Char / Safe Double") = verifyTF(TwoFace.Char('\u0006') / TwoFace.Double(2.0), 3.0)
  property("Safe Char / Unsafe Double") = verifyTF(TwoFace.Char('\u0006') / TwoFace.Double(us(2.0)), us(3.0))
  property("Unsafe Char / Safe Double") = verifyTF(TwoFace.Char(us('\u0006')) / TwoFace.Double(2.0), us(3.0))
  property("Unsafe Char / Unsafe Double") = verifyTF(TwoFace.Char(us('\u0006')) / TwoFace.Double(us(2.0)), us(3.0))

  property("Safe Char % Safe Char") = verifyTF(TwoFace.Char('\u0007') % TwoFace.Char('\u0004'), 3)
  property("Safe Char % Unsafe Char") = verifyTF(TwoFace.Char('\u0007') % TwoFace.Char(us('\u0004')), us(3))
  property("Unsafe Char % Safe Char") = verifyTF(TwoFace.Char(us('\u0007')) % TwoFace.Char('\u0004'), us(3))
  property("Unsafe Char % Unsafe Char") = verifyTF(TwoFace.Char(us('\u0007')) % TwoFace.Char(us('\u0004')), us(3))
  property("Safe Char % Safe Int") = verifyTF(TwoFace.Char('\u0007') % TwoFace.Int(4), 3)
  property("Safe Char % Unsafe Int") = verifyTF(TwoFace.Char('\u0007') % TwoFace.Int(us(4)), us(3))
  property("Unsafe Char % Safe Int") = verifyTF(TwoFace.Char(us('\u0007')) % TwoFace.Int(4), us(3))
  property("Unsafe Char % Unsafe Int") = verifyTF(TwoFace.Char(us('\u0007')) % TwoFace.Int(us(4)), us(3))
  property("Safe Char % Safe Long") = verifyTF(TwoFace.Char('\u0007') % TwoFace.Long(4L), 3L)
  property("Safe Char % Unsafe Long") = verifyTF(TwoFace.Char('\u0007') % TwoFace.Long(us(4L)), us(3L))
  property("Unsafe Char % Safe Long") = verifyTF(TwoFace.Char(us('\u0007')) % TwoFace.Long(4L), us(3L))
  property("Unsafe Char % Unsafe Long") = verifyTF(TwoFace.Char(us('\u0007')) % TwoFace.Long(us(4L)), us(3L))
  property("Safe Char % Safe Float") = verifyTF(TwoFace.Char('\u0007') % TwoFace.Float(4.0f), 3.0f)
  property("Safe Char % Unsafe Float") = verifyTF(TwoFace.Char('\u0007') % TwoFace.Float(us(4.0f)), us(3.0f))
  property("Unsafe Char % Safe Float") = verifyTF(TwoFace.Char(us('\u0007')) % TwoFace.Float(4.0f), us(3.0f))
  property("Unsafe Char % Unsafe Float") = verifyTF(TwoFace.Char(us('\u0007')) % TwoFace.Float(us(4.0f)), us(3.0f))
  property("Safe Char % Safe Double") = verifyTF(TwoFace.Char('\u0007') % TwoFace.Double(4.0), 3.0)
  property("Safe Char % Unsafe Double") = verifyTF(TwoFace.Char('\u0007') % TwoFace.Double(us(4.0)), us(3.0))
  property("Unsafe Char % Safe Double") = verifyTF(TwoFace.Char(us('\u0007')) % TwoFace.Double(4.0), us(3.0))
  property("Unsafe Char % Unsafe Double") = verifyTF(TwoFace.Char(us('\u0007')) % TwoFace.Double(us(4.0)), us(3.0))

  property("Safe Char < Safe Char") = verifyTF(TwoFace.Char('\u0007') < TwoFace.Char('\u0004'), false)
  property("Safe Char < Unsafe Char") = verifyTF(TwoFace.Char('\u0007') < TwoFace.Char(us('\u0004')), us(false))
  property("Unsafe Char < Safe Char") = verifyTF(TwoFace.Char(us('\u0007')) < TwoFace.Char('\u0004'), us(false))
  property("Unsafe Char < Unsafe Char") = verifyTF(TwoFace.Char(us('\u0007')) < TwoFace.Char(us('\u0004')), us(false))
  property("Safe Char < Safe Int") = verifyTF(TwoFace.Char('\u0007') < TwoFace.Int(4), false)
  property("Safe Char < Unsafe Int") = verifyTF(TwoFace.Char('\u0007') < TwoFace.Int(us(4)), us(false))
  property("Unsafe Char < Safe Int") = verifyTF(TwoFace.Char(us('\u0007')) < TwoFace.Int(4), us(false))
  property("Unsafe Char < Unsafe Int") = verifyTF(TwoFace.Char(us('\u0007')) < TwoFace.Int(us(4)), us(false))
  property("Safe Char < Safe Long") = verifyTF(TwoFace.Char('\u0007') < TwoFace.Long(4L), false)
  property("Safe Char < Unsafe Long") = verifyTF(TwoFace.Char('\u0007') < TwoFace.Long(us(4L)), us(false))
  property("Unsafe Char < Safe Long") = verifyTF(TwoFace.Char(us('\u0007')) < TwoFace.Long(4L), us(false))
  property("Unsafe Char < Unsafe Long") = verifyTF(TwoFace.Char(us('\u0007')) < TwoFace.Long(us(4L)), us(false))
  property("Safe Char < Safe Float") = verifyTF(TwoFace.Char('\u0007') < TwoFace.Float(4.0f), false)
  property("Safe Char < Unsafe Float") = verifyTF(TwoFace.Char('\u0007') < TwoFace.Float(us(4.0f)), us(false))
  property("Unsafe Char < Safe Float") = verifyTF(TwoFace.Char(us('\u0007')) < TwoFace.Float(4.0f), us(false))
  property("Unsafe Char < Unsafe Float") = verifyTF(TwoFace.Char(us('\u0007')) < TwoFace.Float(us(4.0f)), us(false))
  property("Safe Char < Safe Double") = verifyTF(TwoFace.Char('\u0007') < TwoFace.Double(4.0), false)
  property("Safe Char < Unsafe Double") = verifyTF(TwoFace.Char('\u0007') < TwoFace.Double(us(4.0)), us(false))
  property("Unsafe Char < Safe Double") = verifyTF(TwoFace.Char(us('\u0007')) < TwoFace.Double(4.0), us(false))
  property("Unsafe Char < Unsafe Double") = verifyTF(TwoFace.Char(us('\u0007')) < TwoFace.Double(us(4.0)), us(false))

  property("Safe Char > Safe Char") = verifyTF(TwoFace.Char('\u0007') > TwoFace.Char('\u0004'), true)
  property("Safe Char > Unsafe Char") = verifyTF(TwoFace.Char('\u0007') > TwoFace.Char(us('\u0004')), us(true))
  property("Unsafe Char > Safe Char") = verifyTF(TwoFace.Char(us('\u0007')) > TwoFace.Char('\u0004'), us(true))
  property("Unsafe Char > Unsafe Char") = verifyTF(TwoFace.Char(us('\u0007')) > TwoFace.Char(us('\u0004')), us(true))
  property("Safe Char > Safe Int") = verifyTF(TwoFace.Char('\u0007') > TwoFace.Int(4), true)
  property("Safe Char > Unsafe Int") = verifyTF(TwoFace.Char('\u0007') > TwoFace.Int(us(4)), us(true))
  property("Unsafe Char > Safe Int") = verifyTF(TwoFace.Char(us('\u0007')) > TwoFace.Int(4), us(true))
  property("Unsafe Char > Unsafe Int") = verifyTF(TwoFace.Char(us('\u0007')) > TwoFace.Int(us(4)), us(true))
  property("Safe Char > Safe Long") = verifyTF(TwoFace.Char('\u0007') > TwoFace.Long(4L), true)
  property("Safe Char > Unsafe Long") = verifyTF(TwoFace.Char('\u0007') > TwoFace.Long(us(4L)), us(true))
  property("Unsafe Char > Safe Long") = verifyTF(TwoFace.Char(us('\u0007')) > TwoFace.Long(4L), us(true))
  property("Unsafe Char > Unsafe Long") = verifyTF(TwoFace.Char(us('\u0007')) > TwoFace.Long(us(4L)), us(true))
  property("Safe Char > Safe Float") = verifyTF(TwoFace.Char('\u0007') > TwoFace.Float(4.0f), true)
  property("Safe Char > Unsafe Float") = verifyTF(TwoFace.Char('\u0007') > TwoFace.Float(us(4.0f)), us(true))
  property("Unsafe Char > Safe Float") = verifyTF(TwoFace.Char(us('\u0007')) > TwoFace.Float(4.0f), us(true))
  property("Unsafe Char > Unsafe Float") = verifyTF(TwoFace.Char(us('\u0007')) > TwoFace.Float(us(4.0f)), us(true))
  property("Safe Char > Safe Double") = verifyTF(TwoFace.Char('\u0007') > TwoFace.Double(4.0), true)
  property("Safe Char > Unsafe Double") = verifyTF(TwoFace.Char('\u0007') > TwoFace.Double(us(4.0)), us(true))
  property("Unsafe Char > Safe Double") = verifyTF(TwoFace.Char(us('\u0007')) > TwoFace.Double(4.0), us(true))
  property("Unsafe Char > Unsafe Double") = verifyTF(TwoFace.Char(us('\u0007')) > TwoFace.Double(us(4.0)), us(true))

  property("Safe Char <= Safe Char") = verifyTF(TwoFace.Char('\u0007') <= TwoFace.Char('\u0004'), false)
  property("Safe Char <= Unsafe Char") = verifyTF(TwoFace.Char('\u0007') <= TwoFace.Char(us('\u0004')), us(false))
  property("Unsafe Char <= Safe Char") = verifyTF(TwoFace.Char(us('\u0007')) <= TwoFace.Char('\u0004'), us(false))
  property("Unsafe Char <= Unsafe Char") = verifyTF(TwoFace.Char(us('\u0007')) <= TwoFace.Char(us('\u0004')), us(false))
  property("Safe Char <= Safe Int") = verifyTF(TwoFace.Char('\u0007') <= TwoFace.Int(4), false)
  property("Safe Char <= Unsafe Int") = verifyTF(TwoFace.Char('\u0007') <= TwoFace.Int(us(4)), us(false))
  property("Unsafe Char <= Safe Int") = verifyTF(TwoFace.Char(us('\u0007')) <= TwoFace.Int(4), us(false))
  property("Unsafe Char <= Unsafe Int") = verifyTF(TwoFace.Char(us('\u0007')) <= TwoFace.Int(us(4)), us(false))
  property("Safe Char <= Safe Long") = verifyTF(TwoFace.Char('\u0007') <= TwoFace.Long(4L), false)
  property("Safe Char <= Unsafe Long") = verifyTF(TwoFace.Char('\u0007') <= TwoFace.Long(us(4L)), us(false))
  property("Unsafe Char <= Safe Long") = verifyTF(TwoFace.Char(us('\u0007')) <= TwoFace.Long(4L), us(false))
  property("Unsafe Char <= Unsafe Long") = verifyTF(TwoFace.Char(us('\u0007')) <= TwoFace.Long(us(4L)), us(false))
  property("Safe Char <= Safe Float") = verifyTF(TwoFace.Char('\u0007') <= TwoFace.Float(4.0f), false)
  property("Safe Char <= Unsafe Float") = verifyTF(TwoFace.Char('\u0007') <= TwoFace.Float(us(4.0f)), us(false))
  property("Unsafe Char <= Safe Float") = verifyTF(TwoFace.Char(us('\u0007')) <= TwoFace.Float(4.0f), us(false))
  property("Unsafe Char <= Unsafe Float") = verifyTF(TwoFace.Char(us('\u0007')) <= TwoFace.Float(us(4.0f)), us(false))
  property("Safe Char <= Safe Double") = verifyTF(TwoFace.Char('\u0007') <= TwoFace.Double(4.0), false)
  property("Safe Char <= Unsafe Double") = verifyTF(TwoFace.Char('\u0007') <= TwoFace.Double(us(4.0)), us(false))
  property("Unsafe Char <= Safe Double") = verifyTF(TwoFace.Char(us('\u0007')) <= TwoFace.Double(4.0), us(false))
  property("Unsafe Char <= Unsafe Double") = verifyTF(TwoFace.Char(us('\u0007')) <= TwoFace.Double(us(4.0)), us(false))

  property("Safe Char >= Safe Char") = verifyTF(TwoFace.Char('\u0007') >= TwoFace.Char('\u0004'), true)
  property("Safe Char >= Unsafe Char") = verifyTF(TwoFace.Char('\u0007') >= TwoFace.Char(us('\u0004')), us(true))
  property("Unsafe Char >= Safe Char") = verifyTF(TwoFace.Char(us('\u0007')) >= TwoFace.Char('\u0004'), us(true))
  property("Unsafe Char >= Unsafe Char") = verifyTF(TwoFace.Char(us('\u0007')) >= TwoFace.Char(us('\u0004')), us(true))
  property("Safe Char >= Safe Int") = verifyTF(TwoFace.Char('\u0007') >= TwoFace.Int(4), true)
  property("Safe Char >= Unsafe Int") = verifyTF(TwoFace.Char('\u0007') >= TwoFace.Int(us(4)), us(true))
  property("Unsafe Char >= Safe Int") = verifyTF(TwoFace.Char(us('\u0007')) >= TwoFace.Int(4), us(true))
  property("Unsafe Char >= Unsafe Int") = verifyTF(TwoFace.Char(us('\u0007')) >= TwoFace.Int(us(4)), us(true))
  property("Safe Char >= Safe Long") = verifyTF(TwoFace.Char('\u0007') >= TwoFace.Long(4L), true)
  property("Safe Char >= Unsafe Long") = verifyTF(TwoFace.Char('\u0007') >= TwoFace.Long(us(4L)), us(true))
  property("Unsafe Char >= Safe Long") = verifyTF(TwoFace.Char(us('\u0007')) >= TwoFace.Long(4L), us(true))
  property("Unsafe Char >= Unsafe Long") = verifyTF(TwoFace.Char(us('\u0007')) >= TwoFace.Long(us(4L)), us(true))
  property("Safe Char >= Safe Float") = verifyTF(TwoFace.Char('\u0007') >= TwoFace.Float(4.0f), true)
  property("Safe Char >= Unsafe Float") = verifyTF(TwoFace.Char('\u0007') >= TwoFace.Float(us(4.0f)), us(true))
  property("Unsafe Char >= Safe Float") = verifyTF(TwoFace.Char(us('\u0007')) >= TwoFace.Float(4.0f), us(true))
  property("Unsafe Char >= Unsafe Float") = verifyTF(TwoFace.Char(us('\u0007')) >= TwoFace.Float(us(4.0f)), us(true))
  property("Safe Char >= Safe Double") = verifyTF(TwoFace.Char('\u0007') >= TwoFace.Double(4.0), true)
  property("Safe Char >= Unsafe Double") = verifyTF(TwoFace.Char('\u0007') >= TwoFace.Double(us(4.0)), us(true))
  property("Unsafe Char >= Safe Double") = verifyTF(TwoFace.Char(us('\u0007')) >= TwoFace.Double(4.0), us(true))
  property("Unsafe Char >= Unsafe Double") = verifyTF(TwoFace.Char(us('\u0007')) >= TwoFace.Double(us(4.0)), us(true))

  property("Safe Char == Regular Safe Char") = verifyTF(TwoFace.Char('\u0007') == ('\u0007'), true)
  property("Safe Char == Regular Unsafe Char") = verifyTF(TwoFace.Char('\u0007') == (us('\u0007')), us(true))
  property("Unsafe Char == Regular Safe Char") = verifyTF(TwoFace.Char(us('\u0007')) == ('\u0007'), us(true))
  property("Unsafe Char == Regular Unsafe Char") = verifyTF(TwoFace.Char(us('\u0007')) == (us('\u0007')), us(true))
  property("Safe Char == Regular Safe Int") = verifyTF(TwoFace.Char('\u0007') == (7), true)
  property("Safe Char == Regular Unsafe Int") = verifyTF(TwoFace.Char('\u0007') == (us(7)), us(true))
  property("Unsafe Char == Regular Safe Int") = verifyTF(TwoFace.Char(us('\u0007')) == (7), us(true))
  property("Unsafe Char == Regular Unsafe Int") = verifyTF(TwoFace.Char(us('\u0007')) == (us(7)), us(true))
  property("Safe Char == Regular Safe Long") = verifyTF(TwoFace.Char('\u0007') == (7L), true)
  property("Safe Char == Regular Unsafe Long") = verifyTF(TwoFace.Char('\u0007') == (us(7L)), us(true))
  property("Unsafe Char == Regular Safe Long") = verifyTF(TwoFace.Char(us('\u0007')) == (7L), us(true))
  property("Unsafe Char == Regular Unsafe Long") = verifyTF(TwoFace.Char(us('\u0007')) == (us(7L)), us(true))
  property("Safe Char == Regular Safe Float") = verifyTF(TwoFace.Char('\u0007') == (7.0f), true)
  property("Safe Char == Regular Unsafe Float") = verifyTF(TwoFace.Char('\u0007') == (us(7.0f)), us(true))
  property("Unsafe Char == Regular Safe Float") = verifyTF(TwoFace.Char(us('\u0007')) == (7.0f), us(true))
  property("Unsafe Char == Regular Unsafe Float") = verifyTF(TwoFace.Char(us('\u0007')) == (us(7.0f)), us(true))
  property("Safe Char == Regular Safe Double") = verifyTF(TwoFace.Char('\u0007') == (7.0), true)
  property("Safe Char == Regular Unsafe Double") = verifyTF(TwoFace.Char('\u0007') == (us(7.0)), us(true))
  property("Unsafe Char == Regular Safe Double") = verifyTF(TwoFace.Char(us('\u0007')) == (7.0), us(true))
  property("Unsafe Char == Regular Unsafe Double") = verifyTF(TwoFace.Char(us('\u0007')) == (us(7.0)), us(true))

  property("Safe Char == Safe Char") = verifyTF(TwoFace.Char('\u0007') == TwoFace.Char('\u0007'), true)
  property("Safe Char == Unsafe Char") = verifyTF(TwoFace.Char('\u0007') == TwoFace.Char(us('\u0007')), us(true))
  property("Unsafe Char == Safe Char") = verifyTF(TwoFace.Char(us('\u0007')) == TwoFace.Char('\u0007'), us(true))
  property("Unsafe Char == Unsafe Char") = verifyTF(TwoFace.Char(us('\u0007')) == TwoFace.Char(us('\u0007')), us(true))
  property("Safe Char == Safe Int") = verifyTF(TwoFace.Char('\u0007') == TwoFace.Int(7), true)
  property("Safe Char == Unsafe Int") = verifyTF(TwoFace.Char('\u0007') == TwoFace.Int(us(7)), us(true))
  property("Unsafe Char == Safe Int") = verifyTF(TwoFace.Char(us('\u0007')) == TwoFace.Int(7), us(true))
  property("Unsafe Char == Unsafe Int") = verifyTF(TwoFace.Char(us('\u0007')) == TwoFace.Int(us(7)), us(true))
  property("Safe Char == Safe Long") = verifyTF(TwoFace.Char('\u0007') == TwoFace.Long(7L), true)
  property("Safe Char == Unsafe Long") = verifyTF(TwoFace.Char('\u0007') == TwoFace.Long(us(7L)), us(true))
  property("Unsafe Char == Safe Long") = verifyTF(TwoFace.Char(us('\u0007')) == TwoFace.Long(7L), us(true))
  property("Unsafe Char == Unsafe Long") = verifyTF(TwoFace.Char(us('\u0007')) == TwoFace.Long(us(7L)), us(true))
  property("Safe Char == Safe Float") = verifyTF(TwoFace.Char('\u0007') == TwoFace.Float(7.0f), true)
  property("Safe Char == Unsafe Float") = verifyTF(TwoFace.Char('\u0007') == TwoFace.Float(us(7.0f)), us(true))
  property("Unsafe Char == Safe Float") = verifyTF(TwoFace.Char(us('\u0007')) == TwoFace.Float(7.0f), us(true))
  property("Unsafe Char == Unsafe Float") = verifyTF(TwoFace.Char(us('\u0007')) == TwoFace.Float(us(7.0f)), us(true))
  property("Safe Char == Safe Double") = verifyTF(TwoFace.Char('\u0007') == TwoFace.Double(7.0), true)
  property("Safe Char == Unsafe Double") = verifyTF(TwoFace.Char('\u0007') == TwoFace.Double(us(7.0)), us(true))
  property("Unsafe Char == Safe Double") = verifyTF(TwoFace.Char(us('\u0007')) == TwoFace.Double(7.0), us(true))
  property("Unsafe Char == Unsafe Double") = verifyTF(TwoFace.Char(us('\u0007')) == TwoFace.Double(us(7.0)), us(true))

  property("Safe Char != Safe Char") = verifyTF(TwoFace.Char('\u0007') != TwoFace.Char('\u0007'), false)
  property("Safe Char != Unsafe Char") = verifyTF(TwoFace.Char('\u0007') != TwoFace.Char(us('\u0007')), us(false))
  property("Unsafe Char != Safe Char") = verifyTF(TwoFace.Char(us('\u0007')) != TwoFace.Char('\u0007'), us(false))
  property("Unsafe Char != Unsafe Char") = verifyTF(TwoFace.Char(us('\u0007')) != TwoFace.Char(us('\u0007')), us(false))
  property("Safe Char != Safe Int") = verifyTF(TwoFace.Char('\u0007') != TwoFace.Int(7), false)
  property("Safe Char != Unsafe Int") = verifyTF(TwoFace.Char('\u0007') != TwoFace.Int(us(7)), us(false))
  property("Unsafe Char != Safe Int") = verifyTF(TwoFace.Char(us('\u0007')) != TwoFace.Int(7), us(false))
  property("Unsafe Char != Unsafe Int") = verifyTF(TwoFace.Char(us('\u0007')) != TwoFace.Int(us(7)), us(false))
  property("Safe Char != Safe Long") = verifyTF(TwoFace.Char('\u0007') != TwoFace.Long(7L), false)
  property("Safe Char != Unsafe Long") = verifyTF(TwoFace.Char('\u0007') != TwoFace.Long(us(7L)), us(false))
  property("Unsafe Char != Safe Long") = verifyTF(TwoFace.Char(us('\u0007')) != TwoFace.Long(7L), us(false))
  property("Unsafe Char != Unsafe Long") = verifyTF(TwoFace.Char(us('\u0007')) != TwoFace.Long(us(7L)), us(false))
  property("Safe Char != Safe Float") = verifyTF(TwoFace.Char('\u0007') != TwoFace.Float(7.0f), false)
  property("Safe Char != Unsafe Float") = verifyTF(TwoFace.Char('\u0007') != TwoFace.Float(us(7.0f)), us(false))
  property("Unsafe Char != Safe Float") = verifyTF(TwoFace.Char(us('\u0007')) != TwoFace.Float(7.0f), us(false))
  property("Unsafe Char != Unsafe Float") = verifyTF(TwoFace.Char(us('\u0007')) != TwoFace.Float(us(7.0f)), us(false))
  property("Safe Char != Safe Double") = verifyTF(TwoFace.Char('\u0007') != TwoFace.Double(7.0), false)
  property("Safe Char != Unsafe Double") = verifyTF(TwoFace.Char('\u0007') != TwoFace.Double(us(7.0)), us(false))
  property("Unsafe Char != Safe Double") = verifyTF(TwoFace.Char(us('\u0007')) != TwoFace.Double(7.0), us(false))
  property("Unsafe Char != Unsafe Double") = verifyTF(TwoFace.Char(us('\u0007')) != TwoFace.Double(us(7.0)), us(false))

  property("Safe Negate") = verifyTF(-TwoFace.Char('\u0002'), -2)
  property("Unsafe Negate") = verifyTF(-TwoFace.Char(us('\u0002')), us(-2))

  property("Safe toInt") = verifyTF(TwoFace.Char('\u0001').toInt, 1)
  property("Unsafe toInt") = verifyTF(TwoFace.Char(us('\u0001')).toInt, us(1))
  property("Safe toLong") = verifyTF(TwoFace.Char('\u0001').toLong, 1L)
  property("Unsafe toLong") = verifyTF(TwoFace.Char(us('\u0001')).toLong, us(1L))
  property("Safe toFloat") = verifyTF(TwoFace.Char('\u0001').toFloat, 1.0f)
  property("Unsafe toFloat") = verifyTF(TwoFace.Char(us('\u0001')).toFloat, us(1.0f))
  property("Safe toDouble") = verifyTF(TwoFace.Char('\u0001').toDouble, 1.0)
  property("Unsafe toDouble") = verifyTF(TwoFace.Char(us('\u0001')).toDouble, us(1.0))
  property("Safe toStringTF") = verifyTF(TwoFace.Char('t').toStringTF, "t")
  property("Unsafe toStringTF") = verifyTF(TwoFace.Char(us('t')).toStringTF, us("t"))

  property("Implicit Conversions") = wellTyped {
    val d : '\u0003' = TwoFace.Char('\u0003')
    val e : Char = TwoFace.Char(us('\u0003'))
  }

  property("ToString") = {
    TwoFace.Char['t'].toString() == "t"
  }

  type Fin = '\u0003'
  final val fin = '\u0003'
  property("Extracting from Safe TwoFace") = {
    val a = TwoFace.Char(fin)
    val ret = shapeless.the[Id[a.type]]
    implicitly[ret.Out =:= Fin]
    ret.value == fin
  }

  property("Extracting from Unsafe TwoFace") = wellTyped {
    val a = TwoFace.Char(us(fin))
    val ret = shapeless.the[AcceptNonLiteral[Id[a.type]]]
    implicitly[ret.Out =:= Char]
    ret.value == fin
  }

  def noImplFoo[W](w : TwoFace.Char[W]) = w.toInt.toChar //Missing twoface shell implicit
  property("Unavailable Implicit Safe TwoFace Shell") = {
    val ret = noImplFoo('\u0002')
    implicitly[ret.type <:< TwoFace.Char[ToChar[ToInt['\u0002']]]]
    val retSimple = ret.simplify
    implicitly[retSimple.type <:< TwoFace.Char['\u0002']]
    retSimple.getValue == '\u0002'
  }
  property("Unavailable Implicit Unsafe TwoFace Shell") = {
    val ret = noImplFoo(us('\u0002'))
    implicitly[ret.type <:< TwoFace.Char[ToChar[ToInt[Char]]]]
    val retSimple = ret.simplify
    implicitly[retSimple.type <:< TwoFace.Char[Char]]
    retSimple.getValue == '\u0002'
  }
}