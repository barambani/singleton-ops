package singleton.twoface

import singleton.twoface.math._
import org.scalacheck.Properties
import shapeless.test.illTyped
import singleton.TestUtils._
import singleton.ops._

class TwoFaceLongSpec extends Properties("TwoFace.Long") {
  property("Implicit Creation[]") = {
    val a = implicitly[TwoFace.Long[2L]]
    a.getValue == 2L && a.isLiteral
  }
  property("Safe Creation[]") = {
    val a = TwoFace.Long[2L]
    a.getValue == 2L && a.isLiteral
  }
  property("Safe Creation()") = {
    val a = TwoFace.Long(2L)
    a.getValue == 2L && a.isLiteral
  }
  property("Unsafe Creation()") = {
    val a = TwoFace.Long(us(2L))
    a.getValue == 2L && !a.isLiteral
  }

  property("Safe ifThenElse") = verifyTF(ifThenElse(true, 1L, 2L), 1L)
  property("Unsafe ifThenElse") = verifyTF(ifThenElse(us(false), 1L, 2L), us(2L))

  property("Safe Long + Safe Char") = verifyTF(TwoFace.Long(2L) + TwoFace.Char('\u0001'), 3L)
  property("Safe Long + Unsafe Char") = verifyTF(TwoFace.Long(2L) + TwoFace.Char(us('\u0001')), us(3L))
  property("Unsafe Long + Safe Char") = verifyTF(TwoFace.Long(us(2L)) + TwoFace.Char('\u0001'), us(3L))
  property("Unsafe Long + Unsafe Char") = verifyTF(TwoFace.Long(us(2L)) + TwoFace.Char(us('\u0001')), us(3L))
  property("Safe Long + Safe Int") = verifyTF(TwoFace.Long(2L) + TwoFace.Int(1), 3L)
  property("Safe Long + Unsafe Int") = verifyTF(TwoFace.Long(2L) + TwoFace.Int(us(1)), us(3L))
  property("Unsafe Long + Safe Int") = verifyTF(TwoFace.Long(us(2L)) + TwoFace.Int(1), us(3L))
  property("Unsafe Long + Unsafe Int") = verifyTF(TwoFace.Long(us(2L)) + TwoFace.Int(us(1)), us(3L))
  property("Safe Long + Safe Long") = verifyTF(TwoFace.Long(2L) + TwoFace.Long(1L), 3L)
  property("Safe Long + Unsafe Long") = verifyTF(TwoFace.Long(2L) + TwoFace.Long(us(1L)), us(3L))
  property("Unsafe Long + Safe Long") = verifyTF(TwoFace.Long(us(2L)) + TwoFace.Long(1L), us(3L))
  property("Unsafe Long + Unsafe Long") = verifyTF(TwoFace.Long(us(2L)) + TwoFace.Long(us(1L)), us(3L))
  property("Safe Long + Safe Float") = verifyTF(TwoFace.Long(2L) + TwoFace.Float(1.0f), 3.0f)
  property("Safe Long + Unsafe Float") = verifyTF(TwoFace.Long(2L) + TwoFace.Float(us(1.0f)), us(3.0f))
  property("Unsafe Long + Safe Float") = verifyTF(TwoFace.Long(us(2L)) + TwoFace.Float(1.0f), us(3.0f))
  property("Unsafe Long + Unsafe Float") = verifyTF(TwoFace.Long(us(2L)) + TwoFace.Float(us(1.0f)), us(3.0f))
  property("Safe Long + Safe Double") = verifyTF(TwoFace.Long(2L) + TwoFace.Double(1.0), 3.0)
  property("Safe Long + Unsafe Double") = verifyTF(TwoFace.Long(2L) + TwoFace.Double(us(1.0)), us(3.0))
  property("Unsafe Long + Safe Double") = verifyTF(TwoFace.Long(us(2L)) + TwoFace.Double(1.0), us(3.0))
  property("Unsafe Long + Unsafe Double") = verifyTF(TwoFace.Long(us(2L)) + TwoFace.Double(us(1.0)), us(3.0))

  property("Safe Long - Safe Char") = verifyTF(TwoFace.Long(2L) - TwoFace.Char('\u0001'), 1L)
  property("Safe Long - Unsafe Char") = verifyTF(TwoFace.Long(2L) - TwoFace.Char(us('\u0001')), us(1L))
  property("Unsafe Long - Safe Char") = verifyTF(TwoFace.Long(us(2L)) - TwoFace.Char('\u0001'), us(1L))
  property("Unsafe Long - Unsafe Char") = verifyTF(TwoFace.Long(us(2L)) - TwoFace.Char(us('\u0001')), us(1L))
  property("Safe Long - Safe Int") = verifyTF(TwoFace.Long(2L) - TwoFace.Int(1), 1L)
  property("Safe Long - Unsafe Int") = verifyTF(TwoFace.Long(2L) - TwoFace.Int(us(1)), us(1L))
  property("Unsafe Long - Safe Int") = verifyTF(TwoFace.Long(us(2L)) - TwoFace.Int(1), us(1L))
  property("Unsafe Long - Unsafe Int") = verifyTF(TwoFace.Long(us(2L)) - TwoFace.Int(us(1)), us(1L))
  property("Safe Long - Safe Long") = verifyTF(TwoFace.Long(2L) - TwoFace.Long(1L), 1L)
  property("Safe Long - Unsafe Long") = verifyTF(TwoFace.Long(2L) - TwoFace.Long(us(1L)), us(1L))
  property("Unsafe Long - Safe Long") = verifyTF(TwoFace.Long(us(2L)) - TwoFace.Long(1L), us(1L))
  property("Unsafe Long - Unsafe Long") = verifyTF(TwoFace.Long(us(2L)) - TwoFace.Long(us(1L)), us(1L))
  property("Safe Long - Safe Float") = verifyTF(TwoFace.Long(2L) - TwoFace.Float(1.0f), 1.0f)
  property("Safe Long - Unsafe Float") = verifyTF(TwoFace.Long(2L) - TwoFace.Float(us(1.0f)), us(1.0f))
  property("Unsafe Long - Safe Float") = verifyTF(TwoFace.Long(us(2L)) - TwoFace.Float(1.0f), us(1.0f))
  property("Unsafe Long - Unsafe Float") = verifyTF(TwoFace.Long(us(2L)) - TwoFace.Float(us(1.0f)), us(1.0f))
  property("Safe Long - Safe Double") = verifyTF(TwoFace.Long(2L) - TwoFace.Double(1.0), 1.0)
  property("Safe Long - Unsafe Double") = verifyTF(TwoFace.Long(2L) - TwoFace.Double(us(1.0)), us(1.0))
  property("Unsafe Long - Safe Double") = verifyTF(TwoFace.Long(us(2L)) - TwoFace.Double(1.0), us(1.0))
  property("Unsafe Long - Unsafe Double") = verifyTF(TwoFace.Long(us(2L)) - TwoFace.Double(us(1.0)), us(1.0))

  property("Safe Long * Safe Char") = verifyTF(TwoFace.Long(2L) * TwoFace.Char('\u0001'), 2L)
  property("Safe Long * Unsafe Char") = verifyTF(TwoFace.Long(2L) * TwoFace.Char(us('\u0001')), us(2L))
  property("Unsafe Long * Safe Char") = verifyTF(TwoFace.Long(us(2L)) * TwoFace.Char('\u0001'), us(2L))
  property("Unsafe Long * Unsafe Char") = verifyTF(TwoFace.Long(us(2L)) * TwoFace.Char(us('\u0001')), us(2L))
  property("Safe Long * Safe Int") = verifyTF(TwoFace.Long(2L) * TwoFace.Int(1), 2L)
  property("Safe Long * Unsafe Int") = verifyTF(TwoFace.Long(2L) * TwoFace.Int(us(1)), us(2L))
  property("Unsafe Long * Safe Int") = verifyTF(TwoFace.Long(us(2L)) * TwoFace.Int(1), us(2L))
  property("Unsafe Long * Unsafe Int") = verifyTF(TwoFace.Long(us(2L)) * TwoFace.Int(us(1)), us(2L))
  property("Safe Long * Safe Long") = verifyTF(TwoFace.Long(2L) * TwoFace.Long(1L), 2L)
  property("Safe Long * Unsafe Long") = verifyTF(TwoFace.Long(2L) * TwoFace.Long(us(1L)), us(2L))
  property("Unsafe Long * Safe Long") = verifyTF(TwoFace.Long(us(2L)) * TwoFace.Long(1L), us(2L))
  property("Unsafe Long * Unsafe Long") = verifyTF(TwoFace.Long(us(2L)) * TwoFace.Long(us(1L)), us(2L))
  property("Safe Long * Safe Float") = verifyTF(TwoFace.Long(2L) * TwoFace.Float(1.0f), 2.0f)
  property("Safe Long * Unsafe Float") = verifyTF(TwoFace.Long(2L) * TwoFace.Float(us(1.0f)), us(2.0f))
  property("Unsafe Long * Safe Float") = verifyTF(TwoFace.Long(us(2L)) * TwoFace.Float(1.0f), us(2.0f))
  property("Unsafe Long * Unsafe Float") = verifyTF(TwoFace.Long(us(2L)) * TwoFace.Float(us(1.0f)), us(2.0f))
  property("Safe Long * Safe Double") = verifyTF(TwoFace.Long(2L) * TwoFace.Double(1.0), 2.0)
  property("Safe Long * Unsafe Double") = verifyTF(TwoFace.Long(2L) * TwoFace.Double(us(1.0)), us(2.0))
  property("Unsafe Long * Safe Double") = verifyTF(TwoFace.Long(us(2L)) * TwoFace.Double(1.0), us(2.0))
  property("Unsafe Long * Unsafe Double") = verifyTF(TwoFace.Long(us(2L)) * TwoFace.Double(us(1.0)), us(2.0))

  property("Safe Long / Safe Char") = verifyTF(TwoFace.Long(6L) / TwoFace.Char('\u0002'), 3L)
  property("Safe Long / Unsafe Char") = verifyTF(TwoFace.Long(6L) / TwoFace.Char(us('\u0002')), us(3L))
  property("Unsafe Long / Safe Char") = verifyTF(TwoFace.Long(us(6L)) / TwoFace.Char('\u0002'), us(3L))
  property("Unsafe Long / Unsafe Char") = verifyTF(TwoFace.Long(us(6L)) / TwoFace.Char(us('\u0002')), us(3L))
  property("Safe Long / Safe Int") = verifyTF(TwoFace.Long(6L) / TwoFace.Int(2), 3L)
  property("Safe Long / Unsafe Int") = verifyTF(TwoFace.Long(6L) / TwoFace.Int(us(2)), us(3L))
  property("Unsafe Long / Safe Int") = verifyTF(TwoFace.Long(us(6L)) / TwoFace.Int(2), us(3L))
  property("Unsafe Long / Unsafe Int") = verifyTF(TwoFace.Long(us(6L)) / TwoFace.Int(us(2)), us(3L))
  property("Safe Long / Safe Long") = verifyTF(TwoFace.Long(6L) / TwoFace.Long(2L), 3L)
  property("Safe Long / Unsafe Long") = verifyTF(TwoFace.Long(6L) / TwoFace.Long(us(2L)), us(3L))
  property("Unsafe Long / Safe Long") = verifyTF(TwoFace.Long(us(6L)) / TwoFace.Long(2L), us(3L))
  property("Unsafe Long / Unsafe Long") = verifyTF(TwoFace.Long(us(6L)) / TwoFace.Long(us(2L)), us(3L))
  property("Safe Long / Safe Float") = verifyTF(TwoFace.Long(6L) / TwoFace.Float(2.0f), 3.0f)
  property("Safe Long / Unsafe Float") = verifyTF(TwoFace.Long(6L) / TwoFace.Float(us(2.0f)), us(3.0f))
  property("Unsafe Long / Safe Float") = verifyTF(TwoFace.Long(us(6L)) / TwoFace.Float(2.0f), us(3.0f))
  property("Unsafe Long / Unsafe Float") = verifyTF(TwoFace.Long(us(6L)) / TwoFace.Float(us(2.0f)), us(3.0f))
  property("Safe Long / Safe Double") = verifyTF(TwoFace.Long(6L) / TwoFace.Double(2.0), 3.0)
  property("Safe Long / Unsafe Double") = verifyTF(TwoFace.Long(6L) / TwoFace.Double(us(2.0)), us(3.0))
  property("Unsafe Long / Safe Double") = verifyTF(TwoFace.Long(us(6L)) / TwoFace.Double(2.0), us(3.0))
  property("Unsafe Long / Unsafe Double") = verifyTF(TwoFace.Long(us(6L)) / TwoFace.Double(us(2.0)), us(3.0))

  property("Safe Long % Safe Char") = verifyTF(TwoFace.Long(7L) % TwoFace.Char('\u0004'), 3L)
  property("Safe Long % Unsafe Char") = verifyTF(TwoFace.Long(7L) % TwoFace.Char(us('\u0004')), us(3L))
  property("Unsafe Long % Safe Char") = verifyTF(TwoFace.Long(us(7L)) % TwoFace.Char('\u0004'), us(3L))
  property("Unsafe Long % Unsafe Char") = verifyTF(TwoFace.Long(us(7L)) % TwoFace.Char(us('\u0004')), us(3L))
  property("Safe Long % Safe Int") = verifyTF(TwoFace.Long(7L) % TwoFace.Int(4), 3L)
  property("Safe Long % Unsafe Int") = verifyTF(TwoFace.Long(7L) % TwoFace.Int(us(4)), us(3L))
  property("Unsafe Long % Safe Int") = verifyTF(TwoFace.Long(us(7L)) % TwoFace.Int(4), us(3L))
  property("Unsafe Long % Unsafe Int") = verifyTF(TwoFace.Long(us(7L)) % TwoFace.Int(us(4)), us(3L))
  property("Safe Long % Safe Long") = verifyTF(TwoFace.Long(7L) % TwoFace.Long(4L), 3L)
  property("Safe Long % Unsafe Long") = verifyTF(TwoFace.Long(7L) % TwoFace.Long(us(4L)), us(3L))
  property("Unsafe Long % Safe Long") = verifyTF(TwoFace.Long(us(7L)) % TwoFace.Long(4L), us(3L))
  property("Unsafe Long % Unsafe Long") = verifyTF(TwoFace.Long(us(7L)) % TwoFace.Long(us(4L)), us(3L))
  property("Safe Long % Safe Float") = verifyTF(TwoFace.Long(7L) % TwoFace.Float(4.0f), 3.0f)
  property("Safe Long % Unsafe Float") = verifyTF(TwoFace.Long(7L) % TwoFace.Float(us(4.0f)), us(3.0f))
  property("Unsafe Long % Safe Float") = verifyTF(TwoFace.Long(us(7L)) % TwoFace.Float(4.0f), us(3.0f))
  property("Unsafe Long % Unsafe Float") = verifyTF(TwoFace.Long(us(7L)) % TwoFace.Float(us(4.0f)), us(3.0f))
  property("Safe Long % Safe Double") = verifyTF(TwoFace.Long(7L) % TwoFace.Double(4.0), 3.0)
  property("Safe Long % Unsafe Double") = verifyTF(TwoFace.Long(7L) % TwoFace.Double(us(4.0)), us(3.0))
  property("Unsafe Long % Safe Double") = verifyTF(TwoFace.Long(us(7L)) % TwoFace.Double(4.0), us(3.0))
  property("Unsafe Long % Unsafe Double") = verifyTF(TwoFace.Long(us(7L)) % TwoFace.Double(us(4.0)), us(3.0))

  property("Safe Long < Safe Char") = verifyTF(TwoFace.Long(7L) < TwoFace.Char('\u0004'), false)
  property("Safe Long < Unsafe Char") = verifyTF(TwoFace.Long(7L) < TwoFace.Char(us('\u0004')), us(false))
  property("Unsafe Long < Safe Char") = verifyTF(TwoFace.Long(us(7L)) < TwoFace.Char('\u0004'), us(false))
  property("Unsafe Long < Unsafe Char") = verifyTF(TwoFace.Long(us(7L)) < TwoFace.Char(us('\u0004')), us(false))
  property("Safe Long < Safe Int") = verifyTF(TwoFace.Long(7L) < TwoFace.Int(4), false)
  property("Safe Long < Unsafe Int") = verifyTF(TwoFace.Long(7L) < TwoFace.Int(us(4)), us(false))
  property("Unsafe Long < Safe Int") = verifyTF(TwoFace.Long(us(7L)) < TwoFace.Int(4), us(false))
  property("Unsafe Long < Unsafe Int") = verifyTF(TwoFace.Long(us(7L)) < TwoFace.Int(us(4)), us(false))
  property("Safe Long < Safe Long") = verifyTF(TwoFace.Long(7L) < TwoFace.Long(4L), false)
  property("Safe Long < Unsafe Long") = verifyTF(TwoFace.Long(7L) < TwoFace.Long(us(4L)), us(false))
  property("Unsafe Long < Safe Long") = verifyTF(TwoFace.Long(us(7L)) < TwoFace.Long(4L), us(false))
  property("Unsafe Long < Unsafe Long") = verifyTF(TwoFace.Long(us(7L)) < TwoFace.Long(us(4L)), us(false))
  property("Safe Long < Safe Float") = verifyTF(TwoFace.Long(7L) < TwoFace.Float(4.0f), false)
  property("Safe Long < Unsafe Float") = verifyTF(TwoFace.Long(7L) < TwoFace.Float(us(4.0f)), us(false))
  property("Unsafe Long < Safe Float") = verifyTF(TwoFace.Long(us(7L)) < TwoFace.Float(4.0f), us(false))
  property("Unsafe Long < Unsafe Float") = verifyTF(TwoFace.Long(us(7L)) < TwoFace.Float(us(4.0f)), us(false))
  property("Safe Long < Safe Double") = verifyTF(TwoFace.Long(7L) < TwoFace.Double(4.0), false)
  property("Safe Long < Unsafe Double") = verifyTF(TwoFace.Long(7L) < TwoFace.Double(us(4.0)), us(false))
  property("Unsafe Long < Safe Double") = verifyTF(TwoFace.Long(us(7L)) < TwoFace.Double(4.0), us(false))
  property("Unsafe Long < Unsafe Double") = verifyTF(TwoFace.Long(us(7L)) < TwoFace.Double(us(4.0)), us(false))

  property("Safe Long > Safe Char") = verifyTF(TwoFace.Long(7L) > TwoFace.Char('\u0004'), true)
  property("Safe Long > Unsafe Char") = verifyTF(TwoFace.Long(7L) > TwoFace.Char(us('\u0004')), us(true))
  property("Unsafe Long > Safe Char") = verifyTF(TwoFace.Long(us(7L)) > TwoFace.Char('\u0004'), us(true))
  property("Unsafe Long > Unsafe Char") = verifyTF(TwoFace.Long(us(7L)) > TwoFace.Char(us('\u0004')), us(true))
  property("Safe Long > Safe Int") = verifyTF(TwoFace.Long(7L) > TwoFace.Int(4), true)
  property("Safe Long > Unsafe Int") = verifyTF(TwoFace.Long(7L) > TwoFace.Int(us(4)), us(true))
  property("Unsafe Long > Safe Int") = verifyTF(TwoFace.Long(us(7L)) > TwoFace.Int(4), us(true))
  property("Unsafe Long > Unsafe Int") = verifyTF(TwoFace.Long(us(7L)) > TwoFace.Int(us(4)), us(true))
  property("Safe Long > Safe Long") = verifyTF(TwoFace.Long(7L) > TwoFace.Long(4L), true)
  property("Safe Long > Unsafe Long") = verifyTF(TwoFace.Long(7L) > TwoFace.Long(us(4L)), us(true))
  property("Unsafe Long > Safe Long") = verifyTF(TwoFace.Long(us(7L)) > TwoFace.Long(4L), us(true))
  property("Unsafe Long > Unsafe Long") = verifyTF(TwoFace.Long(us(7L)) > TwoFace.Long(us(4L)), us(true))
  property("Safe Long > Safe Float") = verifyTF(TwoFace.Long(7L) > TwoFace.Float(4.0f), true)
  property("Safe Long > Unsafe Float") = verifyTF(TwoFace.Long(7L) > TwoFace.Float(us(4.0f)), us(true))
  property("Unsafe Long > Safe Float") = verifyTF(TwoFace.Long(us(7L)) > TwoFace.Float(4.0f), us(true))
  property("Unsafe Long > Unsafe Float") = verifyTF(TwoFace.Long(us(7L)) > TwoFace.Float(us(4.0f)), us(true))
  property("Safe Long > Safe Double") = verifyTF(TwoFace.Long(7L) > TwoFace.Double(4.0), true)
  property("Safe Long > Unsafe Double") = verifyTF(TwoFace.Long(7L) > TwoFace.Double(us(4.0)), us(true))
  property("Unsafe Long > Safe Double") = verifyTF(TwoFace.Long(us(7L)) > TwoFace.Double(4.0), us(true))
  property("Unsafe Long > Unsafe Double") = verifyTF(TwoFace.Long(us(7L)) > TwoFace.Double(us(4.0)), us(true))

  property("Safe Long <= Safe Char") = verifyTF(TwoFace.Long(7L) <= TwoFace.Char('\u0004'), false)
  property("Safe Long <= Unsafe Char") = verifyTF(TwoFace.Long(7L) <= TwoFace.Char(us('\u0004')), us(false))
  property("Unsafe Long <= Safe Char") = verifyTF(TwoFace.Long(us(7L)) <= TwoFace.Char('\u0004'), us(false))
  property("Unsafe Long <= Unsafe Char") = verifyTF(TwoFace.Long(us(7L)) <= TwoFace.Char(us('\u0004')), us(false))
  property("Safe Long <= Safe Int") = verifyTF(TwoFace.Long(7L) <= TwoFace.Int(4), false)
  property("Safe Long <= Unsafe Int") = verifyTF(TwoFace.Long(7L) <= TwoFace.Int(us(4)), us(false))
  property("Unsafe Long <= Safe Int") = verifyTF(TwoFace.Long(us(7L)) <= TwoFace.Int(4), us(false))
  property("Unsafe Long <= Unsafe Int") = verifyTF(TwoFace.Long(us(7L)) <= TwoFace.Int(us(4)), us(false))
  property("Safe Long <= Safe Long") = verifyTF(TwoFace.Long(7L) <= TwoFace.Long(4L), false)
  property("Safe Long <= Unsafe Long") = verifyTF(TwoFace.Long(7L) <= TwoFace.Long(us(4L)), us(false))
  property("Unsafe Long <= Safe Long") = verifyTF(TwoFace.Long(us(7L)) <= TwoFace.Long(4L), us(false))
  property("Unsafe Long <= Unsafe Long") = verifyTF(TwoFace.Long(us(7L)) <= TwoFace.Long(us(4L)), us(false))
  property("Safe Long <= Safe Float") = verifyTF(TwoFace.Long(7L) <= TwoFace.Float(4.0f), false)
  property("Safe Long <= Unsafe Float") = verifyTF(TwoFace.Long(7L) <= TwoFace.Float(us(4.0f)), us(false))
  property("Unsafe Long <= Safe Float") = verifyTF(TwoFace.Long(us(7L)) <= TwoFace.Float(4.0f), us(false))
  property("Unsafe Long <= Unsafe Float") = verifyTF(TwoFace.Long(us(7L)) <= TwoFace.Float(us(4.0f)), us(false))
  property("Safe Long <= Safe Double") = verifyTF(TwoFace.Long(7L) <= TwoFace.Double(4.0), false)
  property("Safe Long <= Unsafe Double") = verifyTF(TwoFace.Long(7L) <= TwoFace.Double(us(4.0)), us(false))
  property("Unsafe Long <= Safe Double") = verifyTF(TwoFace.Long(us(7L)) <= TwoFace.Double(4.0), us(false))
  property("Unsafe Long <= Unsafe Double") = verifyTF(TwoFace.Long(us(7L)) <= TwoFace.Double(us(4.0)), us(false))

  property("Safe Long >= Safe Char") = verifyTF(TwoFace.Long(7L) >= TwoFace.Char('\u0004'), true)
  property("Safe Long >= Unsafe Char") = verifyTF(TwoFace.Long(7L) >= TwoFace.Char(us('\u0004')), us(true))
  property("Unsafe Long >= Safe Char") = verifyTF(TwoFace.Long(us(7L)) >= TwoFace.Char('\u0004'), us(true))
  property("Unsafe Long >= Unsafe Char") = verifyTF(TwoFace.Long(us(7L)) >= TwoFace.Char(us('\u0004')), us(true))
  property("Safe Long >= Safe Int") = verifyTF(TwoFace.Long(7L) >= TwoFace.Int(4), true)
  property("Safe Long >= Unsafe Int") = verifyTF(TwoFace.Long(7L) >= TwoFace.Int(us(4)), us(true))
  property("Unsafe Long >= Safe Int") = verifyTF(TwoFace.Long(us(7L)) >= TwoFace.Int(4), us(true))
  property("Unsafe Long >= Unsafe Int") = verifyTF(TwoFace.Long(us(7L)) >= TwoFace.Int(us(4)), us(true))
  property("Safe Long >= Safe Long") = verifyTF(TwoFace.Long(7L) >= TwoFace.Long(4L), true)
  property("Safe Long >= Unsafe Long") = verifyTF(TwoFace.Long(7L) >= TwoFace.Long(us(4L)), us(true))
  property("Unsafe Long >= Safe Long") = verifyTF(TwoFace.Long(us(7L)) >= TwoFace.Long(4L), us(true))
  property("Unsafe Long >= Unsafe Long") = verifyTF(TwoFace.Long(us(7L)) >= TwoFace.Long(us(4L)), us(true))
  property("Safe Long >= Safe Float") = verifyTF(TwoFace.Long(7L) >= TwoFace.Float(4.0f), true)
  property("Safe Long >= Unsafe Float") = verifyTF(TwoFace.Long(7L) >= TwoFace.Float(us(4.0f)), us(true))
  property("Unsafe Long >= Safe Float") = verifyTF(TwoFace.Long(us(7L)) >= TwoFace.Float(4.0f), us(true))
  property("Unsafe Long >= Unsafe Float") = verifyTF(TwoFace.Long(us(7L)) >= TwoFace.Float(us(4.0f)), us(true))
  property("Safe Long >= Safe Double") = verifyTF(TwoFace.Long(7L) >= TwoFace.Double(4.0), true)
  property("Safe Long >= Unsafe Double") = verifyTF(TwoFace.Long(7L) >= TwoFace.Double(us(4.0)), us(true))
  property("Unsafe Long >= Safe Double") = verifyTF(TwoFace.Long(us(7L)) >= TwoFace.Double(4.0), us(true))
  property("Unsafe Long >= Unsafe Double") = verifyTF(TwoFace.Long(us(7L)) >= TwoFace.Double(us(4.0)), us(true))

  property("Safe Long == Regular Safe Char") = verifyTF(TwoFace.Long(7L) == ('\u0007'), true)
  property("Safe Long == Regular Unsafe Char") = verifyTF(TwoFace.Long(7L) == (us('\u0007')), us(true))
  property("Unsafe Long == Regular Safe Char") = verifyTF(TwoFace.Long(us(7L)) == ('\u0007'), us(true))
  property("Unsafe Long == Regular Unsafe Char") = verifyTF(TwoFace.Long(us(7L)) == (us('\u0007')), us(true))
  property("Safe Long == Regular Safe Int") = verifyTF(TwoFace.Long(7L) == (7), true)
  property("Safe Long == Regular Unsafe Int") = verifyTF(TwoFace.Long(7L) == (us(7)), us(true))
  property("Unsafe Long == Regular Safe Int") = verifyTF(TwoFace.Long(us(7L)) == (7), us(true))
  property("Unsafe Long == Regular Unsafe Int") = verifyTF(TwoFace.Long(us(7L)) == (us(7)), us(true))
  property("Safe Long == Regular Safe Long") = verifyTF(TwoFace.Long(7L) == (7L), true)
  property("Safe Long == Regular Unsafe Long") = verifyTF(TwoFace.Long(7L) == (us(7L)), us(true))
  property("Unsafe Long == Regular Safe Long") = verifyTF(TwoFace.Long(us(7L)) == (7L), us(true))
  property("Unsafe Long == Regular Unsafe Long") = verifyTF(TwoFace.Long(us(7L)) == (us(7L)), us(true))
  property("Safe Long == Regular Safe Float") = verifyTF(TwoFace.Long(7L) == (7.0f), true)
  property("Safe Long == Regular Unsafe Float") = verifyTF(TwoFace.Long(7L) == (us(7.0f)), us(true))
  property("Unsafe Long == Regular Safe Float") = verifyTF(TwoFace.Long(us(7L)) == (7.0f), us(true))
  property("Unsafe Long == Regular Unsafe Float") = verifyTF(TwoFace.Long(us(7L)) == (us(7.0f)), us(true))
  property("Safe Long == Regular Safe Double") = verifyTF(TwoFace.Long(7L) == (7.0), true)
  property("Safe Long == Regular Unsafe Double") = verifyTF(TwoFace.Long(7L) == (us(7.0)), us(true))
  property("Unsafe Long == Regular Safe Double") = verifyTF(TwoFace.Long(us(7L)) == (7.0), us(true))
  property("Unsafe Long == Regular Unsafe Double") = verifyTF(TwoFace.Long(us(7L)) == (us(7.0)), us(true))

  property("Safe Long == Safe Char") = verifyTF(TwoFace.Long(7L) == TwoFace.Char('\u0007'), true)
  property("Safe Long == Unsafe Char") = verifyTF(TwoFace.Long(7L) == TwoFace.Char(us('\u0007')), us(true))
  property("Unsafe Long == Safe Char") = verifyTF(TwoFace.Long(us(7L)) == TwoFace.Char('\u0007'), us(true))
  property("Unsafe Long == Unsafe Char") = verifyTF(TwoFace.Long(us(7L)) == TwoFace.Char(us('\u0007')), us(true))
  property("Safe Long == Safe Int") = verifyTF(TwoFace.Long(7L) == TwoFace.Int(7), true)
  property("Safe Long == Unsafe Int") = verifyTF(TwoFace.Long(7L) == TwoFace.Int(us(7)), us(true))
  property("Unsafe Long == Safe Int") = verifyTF(TwoFace.Long(us(7L)) == TwoFace.Int(7), us(true))
  property("Unsafe Long == Unsafe Int") = verifyTF(TwoFace.Long(us(7L)) == TwoFace.Int(us(7)), us(true))
  property("Safe Long == Safe Long") = verifyTF(TwoFace.Long(7L) == TwoFace.Long(7L), true)
  property("Safe Long == Unsafe Long") = verifyTF(TwoFace.Long(7L) == TwoFace.Long(us(7L)), us(true))
  property("Unsafe Long == Safe Long") = verifyTF(TwoFace.Long(us(7L)) == TwoFace.Long(7L), us(true))
  property("Unsafe Long == Unsafe Long") = verifyTF(TwoFace.Long(us(7L)) == TwoFace.Long(us(7L)), us(true))
  property("Safe Long == Safe Float") = verifyTF(TwoFace.Long(7L) == TwoFace.Float(7.0f), true)
  property("Safe Long == Unsafe Float") = verifyTF(TwoFace.Long(7L) == TwoFace.Float(us(7.0f)), us(true))
  property("Unsafe Long == Safe Float") = verifyTF(TwoFace.Long(us(7L)) == TwoFace.Float(7.0f), us(true))
  property("Unsafe Long == Unsafe Float") = verifyTF(TwoFace.Long(us(7L)) == TwoFace.Float(us(7.0f)), us(true))
  property("Safe Long == Safe Double") = verifyTF(TwoFace.Long(7L) == TwoFace.Double(7.0), true)
  property("Safe Long == Unsafe Double") = verifyTF(TwoFace.Long(7L) == TwoFace.Double(us(7.0)), us(true))
  property("Unsafe Long == Safe Double") = verifyTF(TwoFace.Long(us(7L)) == TwoFace.Double(7.0), us(true))
  property("Unsafe Long == Unsafe Double") = verifyTF(TwoFace.Long(us(7L)) == TwoFace.Double(us(7.0)), us(true))

  property("Safe Long != Safe Char") = verifyTF(TwoFace.Long(7L) != TwoFace.Char('\u0007'), false)
  property("Safe Long != Unsafe Char") = verifyTF(TwoFace.Long(7L) != TwoFace.Char(us('\u0007')), us(false))
  property("Unsafe Long != Safe Char") = verifyTF(TwoFace.Long(us(7L)) != TwoFace.Char('\u0007'), us(false))
  property("Unsafe Long != Unsafe Char") = verifyTF(TwoFace.Long(us(7L)) != TwoFace.Char(us('\u0007')), us(false))
  property("Safe Long != Safe Int") = verifyTF(TwoFace.Long(7L) != TwoFace.Int(7), false)
  property("Safe Long != Unsafe Int") = verifyTF(TwoFace.Long(7L) != TwoFace.Int(us(7)), us(false))
  property("Unsafe Long != Safe Int") = verifyTF(TwoFace.Long(us(7L)) != TwoFace.Int(7), us(false))
  property("Unsafe Long != Unsafe Int") = verifyTF(TwoFace.Long(us(7L)) != TwoFace.Int(us(7)), us(false))
  property("Safe Long != Safe Long") = verifyTF(TwoFace.Long(7L) != TwoFace.Long(7L), false)
  property("Safe Long != Unsafe Long") = verifyTF(TwoFace.Long(7L) != TwoFace.Long(us(7L)), us(false))
  property("Unsafe Long != Safe Long") = verifyTF(TwoFace.Long(us(7L)) != TwoFace.Long(7L), us(false))
  property("Unsafe Long != Unsafe Long") = verifyTF(TwoFace.Long(us(7L)) != TwoFace.Long(us(7L)), us(false))
  property("Safe Long != Safe Float") = verifyTF(TwoFace.Long(7L) != TwoFace.Float(7.0f), false)
  property("Safe Long != Unsafe Float") = verifyTF(TwoFace.Long(7L) != TwoFace.Float(us(7.0f)), us(false))
  property("Unsafe Long != Safe Float") = verifyTF(TwoFace.Long(us(7L)) != TwoFace.Float(7.0f), us(false))
  property("Unsafe Long != Unsafe Float") = verifyTF(TwoFace.Long(us(7L)) != TwoFace.Float(us(7.0f)), us(false))
  property("Safe Long != Safe Double") = verifyTF(TwoFace.Long(7L) != TwoFace.Double(7.0), false)
  property("Safe Long != Unsafe Double") = verifyTF(TwoFace.Long(7L) != TwoFace.Double(us(7.0)), us(false))
  property("Unsafe Long != Safe Double") = verifyTF(TwoFace.Long(us(7L)) != TwoFace.Double(7.0), us(false))
  property("Unsafe Long != Unsafe Double") = verifyTF(TwoFace.Long(us(7L)) != TwoFace.Double(us(7.0)), us(false))

  property("Safe Long, Safe Long") = verifyTF(min(TwoFace.Long(2L), TwoFace.Long(1L)), 1L)
  property("Safe Long, Unsafe Long") = verifyTF(min(TwoFace.Long(2L), TwoFace.Long(us(1L))), us(1L))
  property("Unsafe Long, Safe Long") = verifyTF(min(TwoFace.Long(us(2L)), TwoFace.Long(1L)), us(1L))
  property("Unsafe Long, Unsafe Long") = verifyTF(min(TwoFace.Long(us(2L)), TwoFace.Long(us(1L))), us(1L))

  property("Safe Long, Safe Long") = verifyTF(max(TwoFace.Long(2L), TwoFace.Long(1L)), 2L)
  property("Safe Long, Unsafe Long") = verifyTF(max(TwoFace.Long(2L), TwoFace.Long(us(1L))), us(2L))
  property("Unsafe Long, Safe Long") = verifyTF(max(TwoFace.Long(us(2L)), TwoFace.Long(1L)), us(2L))
  property("Unsafe Long, Unsafe Long") = verifyTF(max(TwoFace.Long(us(2L)), TwoFace.Long(us(1L))), us(2L))

  property("Safe Negate") = verifyTF(-TwoFace.Long(-1L), 1L)
  property("Unsafe Negate") = verifyTF(-TwoFace.Long(us(1L)), us(-1L))

  property("Safe toChar") = verifyTF(TwoFace.Long(1L).toChar, '\u0001')
  property("Unsafe toChar") = verifyTF(TwoFace.Long(us(1L)).toChar, us('\u0001'))
  property("Safe toInt") = verifyTF(TwoFace.Long(1L).toInt, 1)
  property("Unsafe toInt") = verifyTF(TwoFace.Long(us(1L)).toInt, us(1))
  property("Safe toFloat") = verifyTF(TwoFace.Long(1L).toFloat, 1.0f)
  property("Unsafe toFloat") = verifyTF(TwoFace.Long(us(1L)).toFloat, us(1.0f))
  property("Safe toDouble") = verifyTF(TwoFace.Long(1L).toDouble, 1.0)
  property("Unsafe toDouble") = verifyTF(TwoFace.Long(us(1L)).toDouble, us(1.0))
  property("Safe toStringTF") = verifyTF(TwoFace.Long(1L).toStringTF, "1")
  property("Unsafe toStringTF") = verifyTF(TwoFace.Long(us(1L)).toStringTF, us("1"))

  property("Safe abs") = verifyTF(abs(TwoFace.Long(-1L)), 1L)
  property("Unsafe abs") = verifyTF(abs(TwoFace.Long(us(-1L))), us(1L))

  property("Safe numberOfLeadingZeros") = verifyTF(TwoFace.Long.numberOfLeadingZeros(TwoFace.Long(1L)), 63)
  property("Unsafe numberOfLeadingZeros") = verifyTF(TwoFace.Long.numberOfLeadingZeros(TwoFace.Long(us(1L))), us(63))

  property("Implicit Conversions") = wellTyped {
    val a : TwoFace.Long[3L] = implicitly[TwoFace.Long[2L + 1L]]
    val b : TwoFace.Long[3L + 0L] = implicitly[TwoFace.Long[2L + 1L]]
    val c : TwoFace.Long[3L + 0L] = implicitly[TwoFace.Long[3L]]
    val d : 3L = TwoFace.Long(3L)
    val e : Long = TwoFace.Long(us(3L))
  }

  property("Wrong Implicit Conversions") = {
    illTyped("""val a : TwoFace.Long[3L] = implicitly[TwoFace.Long[2L + 2L]]""")
    illTyped("""val b : TwoFace.Long[3L + 0L] = implicitly[TwoFace.Long[2L + 2L]]""")
    illTyped("""val c : TwoFace.Long[3L + 0L] = implicitly[TwoFace.Long[4L]]""")
    true
  }

  property("ToString") = {
    TwoFace.Long[1L].toString() == "1"
  }

  type Fin = 3L
  final val fin = 3L
  property("Extracting from Safe TwoFace") = {
    val a = TwoFace.Long(fin)
    val ret = shapeless.the[Id[a.type]]
    implicitly[ret.Out =:= Fin]
    ret.value == fin
  }

  property("Extracting from Unsafe TwoFace") = wellTyped {
    val a = TwoFace.Long(us(fin))
    val ret = shapeless.the[AcceptNonLiteral[Id[a.type]]]
    implicitly[ret.Out =:= Long]
    ret.value == fin
  }

  def noImplFoo[W](w : TwoFace.Long[W]) = -w //Missing twoface shell implicit
  property("Unavailable Implicit Safe TwoFace Shell") = {
    val ret = noImplFoo(2L)
    implicitly[ret.type <:< TwoFace.Long[Negate[2L]]]
    val retSimple = ret.simplify
    implicitly[retSimple.type <:< TwoFace.Long[-2L]]
    retSimple.getValue == -2L
  }
  property("Unavailable Implicit Unsafe TwoFace Shell") = {
    val ret = noImplFoo(us(2L))
    implicitly[ret.type <:< TwoFace.Long[Negate[Long]]]
    val retSimple = ret.simplify
    implicitly[retSimple.type <:< TwoFace.Long[Long]]
    retSimple.getValue == -2L
  }
}